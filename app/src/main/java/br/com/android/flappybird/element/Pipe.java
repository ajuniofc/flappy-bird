package br.com.android.flappybird.element;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.graphic.CanvasGame;
import br.com.android.flappybird.graphic.Colors;

/**
 * Created by JHUNIIN on 06/03/2018.
 */

public class Pipe {
    private static final int PIPE_HEIGHT = 400;
    private static final int PIPE_WIDTH = 100;
    private static final Paint GREEN = Colors.getPipeColor();
    public static final int SCREEN_TOP = 0;
    private CanvasGame canvasGame;
    private int bottomPipeHeight;
    private int topPipeHeight;
    private int position;

    public Pipe(CanvasGame canvas, int position){
        this.canvasGame = canvas;
        this.position = position;
        this.bottomPipeHeight = canvasGame.getHeight() - PIPE_HEIGHT;
        this.topPipeHeight = SCREEN_TOP + PIPE_HEIGHT;
    }

    public void paint(Canvas canvas){
        topPipe(canvas);
        bottomPipe(canvas);
    }

    private void bottomPipe(Canvas canvas) {
        canvas.drawRect(position, bottomPipeHeight, position + PIPE_WIDTH, canvasGame.getHeight(), GREEN);
    }
    private void topPipe(Canvas canvas) {
        canvas.drawRect(position, SCREEN_TOP, position + PIPE_WIDTH, topPipeHeight, GREEN);
    }

    public void move(){
        this.position -= 5;
    }

    private int random(){
        return (int) (Math.random() * 150);
    }

    public boolean leftScreen() {
        return this.position + PIPE_WIDTH < 0;
    }

    public int getPosition() {
        return this.position;
    }
}
