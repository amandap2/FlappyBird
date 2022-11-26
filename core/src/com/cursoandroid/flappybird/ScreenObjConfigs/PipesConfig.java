package com.cursoandroid.flappybird.ScreenObjConfigs;

public class PipesConfig {
    private float widthDispositive;
    private float heightDispositive;
    private float pipeMovementX = 0;
    private float pipeMovementY = 0;
    private float spacePipes = 0;

    public float getWidthDispositive() {
        return widthDispositive;
    }

    public void setWidthDispositive(float widthDispositive) {
        this.widthDispositive = widthDispositive;
    }

    public float getHeightDispositive() {
        return heightDispositive;
    }

    public void setHeightDispositive(float heightDispositive) {
        this.heightDispositive = heightDispositive;
    }

    public float getPipeMovementX() {
        return pipeMovementX;
    }

    public void setPipeMovementX(float pipeMovementX) {
        this.pipeMovementX = pipeMovementX;
    }

    public float getPipeMovementY() {
        return pipeMovementY;
    }

    public void setPipeMovementY(float pipeMovementY) {
        this.pipeMovementY = pipeMovementY;
    }

    public float getSpacePipes() {
        return spacePipes;
    }

    public void setSpacePipes(float spacePipes) {
        this.spacePipes = spacePipes;
    }

    public PipesConfig() {
    }
}
