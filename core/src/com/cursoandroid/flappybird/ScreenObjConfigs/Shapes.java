package com.cursoandroid.flappybird.ScreenObjConfigs;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Shapes {
    private ShapeRenderer shapeRenderer;
    private Circle birdCircle;
    private Rectangle topPipeRectangle;
    private Rectangle bottomPipeRectangle;

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public Circle getBirdCircle() {
        return birdCircle;
    }

    public void setBirdCircle(Circle birdCircle) {
        this.birdCircle = birdCircle;
    }

    public Rectangle getTopPipeRectangle() {
        return topPipeRectangle;
    }

    public void setTopPipeRectangle(Rectangle topPipeRectangle) {
        this.topPipeRectangle = topPipeRectangle;
    }

    public Rectangle getBottomPipeRectangle() {
        return bottomPipeRectangle;
    }

    public void setBottomPipeRectangle(Rectangle bottomPipeRectangle) {
        this.bottomPipeRectangle = bottomPipeRectangle;
    }

    public Shapes() {
    }
}
