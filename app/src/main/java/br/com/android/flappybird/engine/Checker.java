package br.com.android.flappybird.engine;

import br.com.android.flappybird.element.Bird;
import br.com.android.flappybird.element.Pipes;

/**
 * Created by admin on 07/03/2018.
 */

public class Checker {
    private Bird bird;
    private Pipes pipes;

    public Checker(Bird bird, Pipes pipes) {
        this.bird = bird;
        this.pipes = pipes;
    }

    public boolean scored(){
        return false;
    }

    public boolean hasCrash(){
        return this.pipes.hasCrash(bird);
    }
}
