package br.com.android.flappybird.element;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.graphic.CanvasGame;
import br.com.android.flappybird.graphic.Colors;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class Bird {

    private static final float X = 100;
    private static final float RADIUS = 50;
    private static final Paint RED = Colors.getBirdColor();
    private float height;
    private CanvasGame canvasGame;

    public Bird(CanvasGame canvasGame) {
        this.canvasGame = canvasGame;
        this.height = 100;
    }

    public void paint(Canvas canvas){
        canvas.drawCircle(X, height, RADIUS, RED);
    }

    public void fall(){
        if (!isTouchingBottom())
        height += 5;
    }

    private boolean isTouchingBottom() {
        return this.height + RADIUS > this.canvasGame.getHeight();
    }

    public void skip(){

        if (isAbletoSkip()){
            height -= 150;
        }
    }

    private boolean isAbletoSkip() {
        return this.height - RADIUS > X;
    }



}
