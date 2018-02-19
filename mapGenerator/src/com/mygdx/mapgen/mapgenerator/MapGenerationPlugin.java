package com.mygdx.mapgen.mapgenerator;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mapgen.common.Entity;
import com.mygdx.mapgen.common.EntityComponents.PositionComponent;
import com.mygdx.mapgen.common.EntityComponents.SizeComponent;
import com.mygdx.mapgen.common.GameData;
import com.mygdx.mapgen.common.GameMap;
import com.mygdx.mapgen.common.World;
import com.mygdx.mapgen.common.services.IGamePluginService;

import java.util.ArrayList;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class MapGenerationPlugin implements IGamePluginService {

    public final int MAPCOMPONENTWIDTH = 2;


    @Override
    public void start(GameData gameData, World world) {
        world.createNewMap(generateGameMap(gameData));
    }

    private ArrayList<Entity> generateGameMap(GameData gameData) {
        int amountOfMapComponents = gameData.getDisplayWidth()/MAPCOMPONENTWIDTH;
        ArrayList<Entity> mapComponents = new ArrayList<>();
        for(int i = 0 ; i <= amountOfMapComponents; i++){
            SizeComponent sizeComponent = new SizeComponent(MAPCOMPONENTWIDTH, (float) Math.random() * 60);
            PositionComponent positionComponent = new PositionComponent(MAPCOMPONENTWIDTH*i,0.0f,0.0f);
            Entity mapComponent = new Entity();
            mapComponent.add(sizeComponent);
            mapComponent.add(positionComponent);
            updateShape(mapComponent);
            mapComponents.add(mapComponent);

        }
        return mapComponents;
    }

    private void updateShape(Entity mapComponent) {
        float[] shapex = mapComponent.getShapeX();
        float[] shapey = mapComponent.getShapeY();
        PositionComponent positionComponent = mapComponent.getPart(PositionComponent.class);
        SizeComponent sizeComponent = mapComponent.getPart(SizeComponent.class);
        float x = positionComponent.getX();
        float y = positionComponent.getY();
        float radians = positionComponent.getRadians();

        shapex[0] = x;
        shapey[0] = y;

        shapex[1] = x + sizeComponent.getWidth();
        shapey[1] = y;

        shapex[2] = x;
        shapey[2] = y + sizeComponent.getHeight();

        shapex[3] = x + sizeComponent.getWidth();
        shapey[3] = y + sizeComponent.getHeight();

        mapComponent.setShapeX(shapex);
        mapComponent.setShapeY(shapey);
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
