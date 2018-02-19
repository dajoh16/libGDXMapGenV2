package com.mygdx.mapgen.common;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class GameData {

    private float delta;
    private int displayWidth;
    private int displayHeight;

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public float getDelta() {
        return delta;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }
}
