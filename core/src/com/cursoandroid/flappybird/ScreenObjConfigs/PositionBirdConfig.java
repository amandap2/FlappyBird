package com.cursoandroid.flappybird.ScreenObjConfigs;

public class PositionBirdConfig {
    private boolean pipePassed = false;
    private float variation = 0;
    private float birdGravity = 0;
    private float birdFirstPosY = 0;
    private float positionHorizontalBird = 0;

    public PositionBirdConfig() {
    }

    public float getVariation() {
        return variation;
    }

    public void setVariation(float variation) {
        this.variation = variation;
    }

    public float getBirdGravity() {
        return birdGravity;
    }

    public void setBirdGravity(float birdGravity) {
        this.birdGravity = birdGravity;
    }

    public float getBirdFirstPosY() {
        return birdFirstPosY;
    }

    public void setBirdFirstPosY(float birdFirstPosY) {
        this.birdFirstPosY = birdFirstPosY;
    }

    public boolean isPipePassed() {
        return pipePassed;
    }

    public void setPipePassed(boolean pipePassed) {
        this.pipePassed = pipePassed;
    }

    public float getPositionHorizontalBird() {
        return positionHorizontalBird;
    }

    public void setPositionHorizontalBird(float positionHorizontalBird) {
        this.positionHorizontalBird = positionHorizontalBird;
    }
}
