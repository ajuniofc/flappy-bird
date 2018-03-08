package br.com.android.flappybird.element;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.android.flappybird.engine.Sound;
import br.com.android.flappybird.graphic.CanvasGame;

/**
 * Created by admin on 07/03/2018.
 */

public class Pipes {

    public static final int DISTANCE_BETWEEN_PIPES = 600;
    public static final int PIPES_SIZE = 5;
    private final List<Pipe> pipes;
    private CanvasGame canvasGame;
    private Score score;
    private Context context;

    public Pipes(CanvasGame canvasGame, Score score, Context context) {
        this.canvasGame = canvasGame;
        this.score = score;
        this.context = context;
        this.pipes = new ArrayList<>();
        createPipes();
    }

    private void createPipes() {
        int position = 400;
        for (int i = 0; i < PIPES_SIZE; i++) {
            position += DISTANCE_BETWEEN_PIPES;
            pipes.add(new Pipe(this.canvasGame, position, context));
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
                score.score();
                iterator.remove();
                iterator.add(new Pipe(this.canvasGame, getLastPosition() + DISTANCE_BETWEEN_PIPES, context));
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

    public boolean hasCrash(Bird bird) {
        for (Pipe pipe : this.pipes) {
            if (pipe.hasCrash(bird)){
                return true;
            }
        }
        return false;
    }
}
