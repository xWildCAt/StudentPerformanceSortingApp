package model;

public class Timer {

    private long startTime;
    private long stopTime;
    private long elapsedTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

    }

    public long getElapsedTime() {
        return elapsedTime;
    }
};




