package br.com.android.flappybird;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.android.flappybird.engine.Game;

public class MainActivity extends Activity {
    private Game mGame;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer = findViewById(R.id.main_container);
        mGame = new Game(this);
        mContainer.addView(mGame);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startGame();
    }

    private void startGame() {
        mGame.start();
        new Thread(mGame).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGame.pause();
    }
}
