package com.mygdx.mapgen.common.EntityComponents;

import com.mygdx.mapgen.common.GameData;
import com.mygdx.mapgen.common.World;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class SizeComponent implements EntityComponent {

    private float width;
    private float height;

    public SizeComponent(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void process(GameData gameData, World world) {

    }
}
