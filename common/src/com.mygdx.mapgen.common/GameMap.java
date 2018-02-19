package com.mygdx.mapgen.common;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class GameMap {

    private ArrayList<Entity> mapComponents;

    public GameMap() {
        //Creates a default empty map. Can be filled afterwards.
        mapComponents = new ArrayList<>();
    }

    public GameMap(ArrayList<Entity> mapComponents) {
        this.mapComponents = mapComponents;
    }

    public void fillMap(ArrayList<Entity> mapComponents){
        this.mapComponents = mapComponents;
    }

    public ArrayList<Entity> getMapComponents(){
        return this.mapComponents;
    }
}
