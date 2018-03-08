package br.com.android.flappybird.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.android.flappybird.R;

/**
 * Created by admin on 08/03/2018.
 */

public class Sound {

    private final SoundPool soundPool;
    private final int jump;
    private final int crash;
    private final int score;

    public Sound(Context context){
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        jump = soundPool.load(context, R.raw.jump, 1);
        crash = soundPool.load(context, R.raw.scores, 1);
        score = soundPool.load(context, R.raw.scores, 1);
    }

    public void playJump(){
        soundPool.play(jump, 1, 1, 1, 0, 1);
    }

    public void playCrash(){
        soundPool.play(crash, 1, 1, 1, 0, 1);
    }

    public void playScore(){
        soundPool.play(score, 1, 1, 1, 0, 1);
    }
}
