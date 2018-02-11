package sort;

import model.Counter;
import model.Student;

import java.util.ArrayList;

public class Merge extends Counter {

    private static ArrayList<Student> inputArrayG;


    public static ArrayList<Student> sort(ArrayList<Student> inputArray) {
        inputArrayG = inputArray;

        divide(0, inputArray.size() - 1);
        return inputArray;

    }

    private static void divide(int startIndex, int endIndex) {

        //Divide till you breakdown your list to single element
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            divide(startIndex, mid);
            divide(mid + 1, endIndex);

            //merging Sorted array produce above into one sorted array
            merger(startIndex, mid, endIndex);
        }
    }

    private static void merger(int startIndex, int midIndex, int endIndex) {
        incCounter();

        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<Student> mergedSortedArray = new ArrayList<Student>();

        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {


            if (inputArrayG.get(leftIndex).getScore() <= inputArrayG.get(rightIndex).getScore()) {
                mergedSortedArray.add(inputArrayG.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(inputArrayG.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while (leftIndex <= midIndex) {
            mergedSortedArray.add(inputArrayG.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            mergedSortedArray.add(inputArrayG.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while (i < mergedSortedArray.size()) {
            inputArrayG.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }


}