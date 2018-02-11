package controller;

import dao.DataTransfer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Dialog;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;

public class Table {

    private ArrayList<Student> students = new ArrayList<Student>();

    @FXML
    AnchorPane pane;
    @FXML
    TableColumn col_Name, col_Score;
    @FXML
    TableView<Student> tableView;
    @FXML
    Label label_Time;
    @FXML
    Label label_Counter;

    private String saveFile;

    void setInitialValues(ArrayList<Student> students, long time, int counter, String fileName) {
        this.saveFile = fileName;
        this.students = students;
        Collections.reverse(this.students);
        fillTable(students);
        label_Time.setText(String.valueOf(time));
        label_Counter.setText(String.valueOf(counter));
    }


    private void fillTable(ArrayList<Student> students) {

        for (Student student : students) {

            tableView.getItems().add(student);

        }

        col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Score.setCellValueFactory(new PropertyValueFactory<>("score"));

    }

    public void saveToFile() {
        String file = "SORTED_";
        DataTransfer.writeStudents(students, file += saveFile);
        Dialog.showInfo("Save","Successfully saved into the same location as selected file!");
    }


}
