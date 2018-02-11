package sort;

import model.Counter;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;


public class Heap extends Counter {


    public static ArrayList<Student> sort(ArrayList<Student> students) {
        int n = students.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(students, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            incCounter();
            // Move current root to end
            Collections.swap(students, 0, i);

            // call max heapify on the reduced heap
            heapify(students, i, 0);
        }
        return students;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(ArrayList<Student> students, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && students.get(l).getScore() > students.get(largest).getScore())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && students.get(r).getScore() > students.get(largest).getScore())
            largest = r;

        // If largest is not root
        if (largest != i) {
            Collections.swap(students, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(students, n, largest);
        }
    }
    
}


