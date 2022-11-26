package com.cursoandroid.flappybird.GameConfigs;

import com.badlogic.gdx.Preferences;

public class GameStatusControl {
    //save game points
    Preferences prefs;
    private int points = 0;
    private int maxPontuation = 0;
    private int statusGame = 0;

    public Preferences getPrefs() {
        return prefs;
    }

    public void setPrefs(Preferences prefs) {
        this.prefs = prefs;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMaxPontuation() {
        return maxPontuation;
    }

    public void setMaxPontuation(int maxPontuation) {
        this.maxPontuation = maxPontuation;
    }

    public int getStatusGame() {
        return statusGame;
    }

    public void setStatusGame(int statusGame) {
        this.statusGame = statusGame;
    }

    public GameStatusControl() {
    }
}
