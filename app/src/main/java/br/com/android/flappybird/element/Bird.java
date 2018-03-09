package br.com.android.flappybird.element;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.R;
import br.com.android.flappybird.engine.Sound;
import br.com.android.flappybird.engine.Time;
import br.com.android.flappybird.graphic.CanvasGame;
import br.com.android.flappybird.graphic.Colors;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class Bird {

    private static final int JUMP_DISTANCE = 150;
    public static final float X = 100;
    public static final int RADIUS = 50;
    private final Bitmap bird;
    private float height;
    private CanvasGame canvasGame;
    private Sound sound;
    private Time time;

    public Bird(CanvasGame canvasGame, Context context, Sound sound, Time time) {
        this.canvasGame = canvasGame;
        this.sound = sound;
        this.height = 100;
        this.time = time;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        this.bird = Bitmap.createScaledBitmap(bitmap, RADIUS * 2, RADIUS * 2, false);
    }

    public void paint(Canvas canvas){
        canvas.drawBitmap(bird, X - RADIUS, height - RADIUS, null);
    }

    public void fall(){
        double time = this.time.current();
        double newHeight = ((10 * (time * time)) / 2.0);

        if (!isTouchingBottom()) {
            this.height += newHeight;
        }
    }

    private double getNewHeight() {
        double time = this.time.current();
        return 	-JUMP_DISTANCE + ((10 * (time * time))	/ 2);
    }

    private boolean isTouchingBottom() {
        return this.height + RADIUS > this.canvasGame.getHeight();
    }

    public void jump(){
        if (isAbleToJump()){
            sound.playJump();
            time.restart();
            this.height -= 150;
        }
    }

    private boolean isAbleToJump() {
        return this.height > X;
    }

    public float getHeight() {
        return this.height;
    }

}
