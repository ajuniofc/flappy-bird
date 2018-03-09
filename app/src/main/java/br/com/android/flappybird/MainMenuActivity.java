package br.com.android.flappybird;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity implements View.OnClickListener {
    private TextView mPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mPlay = findViewById(R.id.main_menu_play);
        mPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_menu_play:
                startGame();
                break;
        }
    }

    private void startGame() {
        startActivity(new Intent(this, GameActivity.class));
    }
}
