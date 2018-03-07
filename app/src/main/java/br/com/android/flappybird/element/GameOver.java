package br.com.android.flappybird.element;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;

import br.com.android.flappybird.R;
import br.com.android.flappybird.graphic.CanvasGame;
import br.com.android.flappybird.graphic.Colors;

/**
 * Created by admin on 07/03/2018.
 */

public class GameOver {
    private static final Paint RED = Colors.getGameOverColor();
    private Context context;
    private CanvasGame canvasGame;

    public GameOver(Context context, CanvasGame canvasGame) {
        this.context = context;
        this.canvasGame = canvasGame;
    }

    public void paint(Canvas canvas) {
        String stringGameOver = getStringGameOver();
        canvas.drawText(stringGameOver, getTextCenter(stringGameOver), canvasGame.getHeight() / 2,RED);
    }


    private String getStringGameOver() {
        return context.getString(R.string.game_over);
    }

    private int getTextCenter(String stringGameOver){
        Rect rect = new Rect();
        RED.getTextBounds(stringGameOver, 0, stringGameOver.length(), rect);

        return canvasGame.getWidth()/2 - (rect.right - rect.left) / 2;
    }


}
