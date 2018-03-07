package br.com.android.flappybird.element;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.android.flappybird.graphic.Colors;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class Bird {

    private static final float X = 100;
    private static final float RADIUS = 50;
    private static final Paint RED = Colors.getBirdColor();
    private float height = 100;

    public void paint(Canvas canvas){
        canvas.drawCircle(X, height, RADIUS, RED);
    }

    public void fall(){
        height += 5;
    }

    public void skip(){
        height -= 150;
    }

}
