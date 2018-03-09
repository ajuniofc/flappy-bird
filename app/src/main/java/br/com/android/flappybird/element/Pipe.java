package br.com.android.flappybird.element;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.R;
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
    private final int randomHeight;
    private CanvasGame canvasGame;
    private int bottomPipeHeight;
    private int topPipeHeight;
    private int position;
    private Bitmap bottomPipe;
    private Bitmap topPipe;

    public Pipe(CanvasGame canvas, int position, Context context){
        this.canvasGame = canvas;
        this.position = position;
        this.bottomPipeHeight = canvasGame.getHeight() - PIPE_HEIGHT;
        this.topPipeHeight = SCREEN_TOP + PIPE_HEIGHT;
        randomHeight = random();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);
        this.bottomPipe = Bitmap.createScaledBitmap(bitmap, PIPE_WIDTH, bottomPipeHeight, false);
        this.topPipe = Bitmap.createScaledBitmap(bitmap, PIPE_WIDTH, topPipeHeight, false);

    }

    public void paint(Canvas canvas){
        topPipe(canvas);
        bottomPipe(canvas);
    }

    private void bottomPipe(Canvas canvas) {
        canvas.drawBitmap(bottomPipe, position, bottomPipeHeight,null);
    }
    private void topPipe(Canvas canvas) {
        canvas.drawRect(position, SCREEN_TOP, position + PIPE_WIDTH, topPipeHeight, GREEN);
        canvas.drawBitmap(topPipe, position, 0, null);
    }

    public void move(){
        this.position -= 5;
    }

    private int random(){
        return (int) (Math.random() * 150) + 100;
    }

    public boolean leftScreen() {
        return this.position + PIPE_WIDTH < 0;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean hasCrash(Bird bird) {
        return (hasHorizontalCrash(bird)
                && hasVerticalCrash(bird));
    }
    private boolean hasHorizontalCrash(Bird bird){
        return this.position < bird.X + bird.RADIUS;
    }

    private boolean hasVerticalCrash(Bird bird){
        return bird.getHeight() - bird.RADIUS < this.topPipeHeight
                || bird.getHeight() + bird.RADIUS > this.bottomPipeHeight;
    }

}
