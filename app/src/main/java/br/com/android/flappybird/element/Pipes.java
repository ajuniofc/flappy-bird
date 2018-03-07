package br.com.android.flappybird.element;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.android.flappybird.graphic.CanvasGame;

/**
 * Created by admin on 07/03/2018.
 */

public class Pipes {

    public static final int DISTANCE_BETWEEN_PIPES = 400;
    public static final int PIPES_SIZE = 5;
    private final List<Pipe> pipes;
    private CanvasGame canvasGame;

    public Pipes(CanvasGame canvasGame) {
        this.canvasGame = canvasGame;
        this.pipes = new ArrayList<>();
        createPipes();
    }

    private void createPipes() {
        int position = 400;
        for (int i = 0; i < PIPES_SIZE; i++) {
            position += DISTANCE_BETWEEN_PIPES;
            pipes.add(new Pipe(this.canvasGame, position));
        }
    }

    public void paint(Canvas canvas) {
        for (Pipe pipe : this.pipes) {
            pipe.paint(canvas);
        }
    }

    public void move() {
        ListIterator<Pipe> iterator = this.pipes.listIterator();
        while (iterator.hasNext()){
            Pipe pipe = iterator.next();
            pipe.move();
            if (pipe.leftScreen()){
                iterator.remove();
                iterator.add(new Pipe(this.canvasGame, getLastPosition() + DISTANCE_BETWEEN_PIPES));
            }
        }
    }

    private int getLastPosition() {
        int max = 0;
        for (Pipe pipe : this.pipes) {
            max = Math.max(pipe.getPosition(), max);
        }
        return max;
    }
}
