package br.com.android.flappybird.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.android.flappybird.R;
import br.com.android.flappybird.element.Bird;
import br.com.android.flappybird.element.Pipe;
import br.com.android.flappybird.graphic.CanvasGame;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;
    private CanvasGame canvasGame;
    private Bitmap background;
    private Pipe pipe;

    public Game(Context context) {
        super(context);

        canvasGame = new CanvasGame(context);

        initElements();
        setOnTouchListener(this);
    }

    private void initElements() {
        bird = new Bird();
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), canvasGame.getHeight(), false);
        pipe = new Pipe(canvasGame, 800);
    }

    @Override
    public void run() {
        while (isRunning){
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0,0, null);
            bird.paint(canvas);
            bird.fall();
            pipe.paint(canvas);
            pipe.move();


            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void start(){
        isRunning = true;
    }

    public void pause(){
        isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        bird.skip();
        return false;
    }
}
