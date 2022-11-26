package com.cursoandroid.flappybird.GameConfigs;

import com.badlogic.gdx.audio.Sound;

public class GameSounds {
    Sound flyingSound;
    Sound collisionSound;
    Sound pointSound;

    public Sound getFlyingSound() {
        return flyingSound;
    }

    public void setFlyingSound(Sound flyingSound) {
        this.flyingSound = flyingSound;
    }

    public Sound getCollisionSound() {
        return collisionSound;
    }

    public void setCollisionSound(Sound collisionSound) {
        this.collisionSound = collisionSound;
    }

    public Sound getPointSound() {
        return pointSound;
    }

    public void setPointSound(Sound pointSound) {
        this.pointSound = pointSound;
    }

    public GameSounds() {
    }
}
