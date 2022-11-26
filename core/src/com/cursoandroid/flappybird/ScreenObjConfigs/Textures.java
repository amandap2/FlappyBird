package com.cursoandroid.flappybird.ScreenObjConfigs;

import com.badlogic.gdx.graphics.Texture;

public class Textures {
    private Texture[] birds;
    private Texture background;
    private Texture bottomPipe;
    private Texture topPipe;
    private Texture gameOver;


    public Textures() {
    }

    public Texture getBirds(int pos) {
        return birds[pos];
    }

    public void setBirds(Texture[] birds) {
        this.birds = birds;
    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public Texture getBottomPipe() {
        return bottomPipe;
    }

    public void setBottomPipe(Texture bottomPipe) {
        this.bottomPipe = bottomPipe;
    }

    public Texture getTopPipe() {
        return topPipe;
    }

    public void setTopPipe(Texture topPipe) {
        this.topPipe = topPipe;
    }

    public Texture getGameOver() {
        return gameOver;
    }

    public void setGameOver(Texture gameOver) {
        this.gameOver = gameOver;
    }


}
