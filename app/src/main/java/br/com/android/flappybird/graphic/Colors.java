package br.com.android.flappybird.graphic;

import android.graphics.Paint;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class Colors {

    public static Paint getBirdColor(){
        Paint paint = new Paint();
        paint.setColor(0xffff0000);
        return paint;
    }

    public static Paint getPipeColor() {
        Paint paint = new Paint();
        paint.setColor(0xff00ff00);
        return paint;
    }
}
