package model;

public class Counter {

    private static int counter = 0;

    public static int getCounter() {
        int temp = counter;
        nullCounter();
        return temp;

    }

    protected static void incCounter() {
        Counter.counter++;
    }

    private static void nullCounter() {
        Counter.counter = 0;
    }

}
