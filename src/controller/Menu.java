package controller;


import dao.DataTransfer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Dialog;
import model.Student;
import model.Timer;
import sort.Bubble;
import sort.Heap;
import sort.Merge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    ArrayList<Student> students = new ArrayList<>();
    private long time;
    private int counter;
    private String fileName;


    @FXML
    RadioButton radio_Bubble;

    @FXML
    RadioButton radio_Heap;

    @FXML
    RadioButton radio_Merge;

    @FXML
    Label label_File;

    @FXML
    Button btn_Sort;


    private void openTable() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../view/table.fxml"));
        /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage = new Stage();
        stage.setTitle("Informacijos keitimas");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        Table controller = fxmlLoader.<Table>getController();
        controller.setInitialValues(students, time, counter, fileName);
        stage.show();

    }

    public void chooseFile() {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            fileName = selectedFile.getName();
            label_File.setText(fileName);
            btn_Sort.setDisable(false);


        } else {
            Dialog.showError("Error", "No file selected", "File is not chosen.\nPlease, select a .CSV or .TXT file to continue");
        }


    }


    public void launchSort() {
        Timer timer = new Timer();


        if (radio_Bubble.isSelected()) {
            timer.start();
            students = Bubble.sort(DataTransfer.readStudents(fileName));
            timer.stop();
            counter = Bubble.getCounter();

        } else if (radio_Heap.isSelected()) {
            timer.start();
            students = Heap.sort(DataTransfer.readStudents(fileName));
            timer.stop();
            counter = Heap.getCounter();
        } else {
            timer.start();
            students = Merge.sort(DataTransfer.readStudents(fileName));
            timer.stop();
            counter = Merge.getCounter();
        }
        time = timer.getElapsedTime();
        try {
            openTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
