package br.com.android.flappybird.element;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.R;
import br.com.android.flappybird.engine.Sound;
import br.com.android.flappybird.graphic.CanvasGame;
import br.com.android.flappybird.graphic.Colors;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class Bird {

    public static final float X = 100;
    public static final int RADIUS = 50;
    private static final Paint RED = Colors.getBirdColor();
    private final Bitmap bird;
    private float height;
    private CanvasGame canvasGame;
    private Sound sound;

    public Bird(CanvasGame canvasGame, Context context, Sound sound) {
        this.canvasGame = canvasGame;
        this.sound = sound;
        this.height = 100;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        this.bird = Bitmap.createScaledBitmap(bitmap, RADIUS * 2, RADIUS * 2, false);
    }

    public void paint(Canvas canvas){
        canvas.drawBitmap(bird, X -RADIUS, height - RADIUS, null);
    }

    public void fall(){
        if (!isTouchingBottom())
        height += 5;
    }

    private boolean isTouchingBottom() {
        return this.height + RADIUS > this.canvasGame.getHeight();
    }

    public void jump(){
        if (isAbleToJump()){
            sound.playJump();
            height -= 150;
        }
    }

    private boolean isAbleToJump() {
        return this.height - RADIUS > X;
    }

    public float getHeight() {
        return this.height;
    }

}
