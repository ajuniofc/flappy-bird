package br.com.android.flappybird.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

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

    public static Paint getScoreColor() {
        Paint paint = new Paint();
        paint.setColor(0xffffffff);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, 0xFF000000);
        return paint;
    }

}
