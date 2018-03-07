package br.com.android.flappybird.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by JHUNIIN on 05/03/2018.
 */

public class CanvasGame {

    private DisplayMetrics metrics;

    public CanvasGame(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public int getHeight(){
        return metrics.heightPixels;
    }
}
