package com.cursoandroid.flappybird.GameConfigs;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameCameraConfig {
    private OrthographicCamera camera;
    private Viewport viewport;
    private final float VIRTUAL_WIDTH = 720;
    private final float VIRTUAL_HEIGHT = 1280;

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public float getVIRTUAL_WIDTH() {
        return VIRTUAL_WIDTH;
    }

    public float getVIRTUAL_HEIGHT() {
        return VIRTUAL_HEIGHT;
    }

    public GameCameraConfig() {
    }
}
