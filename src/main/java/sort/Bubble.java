package sort;

import model.Counter;
import model.Student;

import java.util.ArrayList;

public class Bubble extends Counter {


    public static ArrayList<Student> sort(ArrayList<Student> list) {
        Student temp;
        if (list.size() > 1) // check if the number of orders is larger than 1
        {
            for (int x = 0; x < list.size(); x++) // bubble sort outer loop
            {
                for (int i = 0; i < list.size() - x - 1; i++)
                    if (list.get(i).getScore() > (list.get(i + 1).getScore())) {
                        incCounter();
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
            }
        }
        return list;
    }

}
