package dao;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class DataTransfer {

    public static ArrayList<Student> readStudents(String loadFileName) {
        ArrayList<Student> students = new ArrayList<Student>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(loadFileName))) {

            while ((line = br.readLine()) != null) {
                String[] studentStr = line.split(csvSplitBy);
                students.add(new Student(studentStr[0], Double.parseDouble(studentStr[1])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;


    }

    public static void writeStudents(ArrayList<Student> students, String saveFile) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(saveFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            for (Student student : students) {
                writer.write(student.getName() + "," + student.getScore()+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
