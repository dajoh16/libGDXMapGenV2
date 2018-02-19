package com.mygdx.mapgen.common.EntityComponents;

import com.mygdx.mapgen.common.GameData;
import com.mygdx.mapgen.common.World;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class PositionComponent implements EntityComponent {
    private float x;
    private float y;
    private float radians;

    public PositionComponent(float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadians() {
        return radians;
    }

    public void setX(float newX) {
        this.x = newX;
    }

    public void setY(float newY) {
        this.y = newY;
    }

    public void setPosition(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    public void setRadians(float radians) {
        this.radians = radians;
    }

    @Override
    public void process(GameData gameData, World world) {

    }
}
