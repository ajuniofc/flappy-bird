package br.com.android.flappybird.engine;

/**
 * Created by admin on 09/03/2018.
 */

public class Time {

    private double current;

    public double current() {
        return this.current;
    }

    public void incrementTime(){
        this.current += 0.05;
    }

    public void restart() {
        this.current = 0;
    }
}
