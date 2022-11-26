package com.cursoandroid.flappybird.GameConfigs;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameText {
    BitmapFont textPoints;
    BitmapFont textRestart;
    BitmapFont textBestPontuation;

    public BitmapFont getTextPoints() {
        return textPoints;
    }

    public void setTextPoints(BitmapFont textPoints) {
        this.textPoints = textPoints;
    }

    public BitmapFont getTextRestart() {
        return textRestart;
    }

    public void setTextRestart(BitmapFont textRestart) {
        this.textRestart = textRestart;
    }

    public BitmapFont getTextBestPontuation() {
        return textBestPontuation;
    }

    public void setTextBestPontuation(BitmapFont textBestPontuation) {
        this.textBestPontuation = textBestPontuation;
    }

    public GameText() {
    }
}
