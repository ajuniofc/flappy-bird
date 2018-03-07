package br.com.android.flappybird.element;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.graphic.CanvasGame;
import br.com.android.flappybird.graphic.Colors;

/**
 * Created by JHUNIIN on 06/03/2018.
 */

public class Pipe {
    private static final int PIPE_HEIGHT = 250;
    private static final int PIPE_WIDTH = 100;
    private static final Paint GREEN = Colors.getPipeColor();
    private CanvasGame canvasGame;
    private int bottomPipeHeight;
    private int position;

    public Pipe(CanvasGame canvas, int position){
        this.canvasGame = canvas;
        this.position = position;
        this.bottomPipeHeight = canvasGame.getHeight() - PIPE_HEIGHT;
    }

    public void paint(Canvas canvas){
        BottomPipe(canvas);
    }

    private void BottomPipe(Canvas canvas) {
        canvas.drawRect(position, bottomPipeHeight, position + PIPE_WIDTH, canvasGame.getHeight(), GREEN);
    }

    public void move(){
        this.position -= 5;
    }

}
