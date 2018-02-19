package com.mygdx.mapgen.common;

import com.badlogic.gdx.math.Rectangle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class World {
    private GameMap map;
    private final Map<String, Entity> entityMap = new ConcurrentHashMap<>();

    public World() {
        //Creates a blank map
        map = new GameMap();

    }

    public Collection<Entity> getEntities() {
        return entityMap.values();
    }

    public void createNewMap(ArrayList<Entity> mapComponents) {
        map = new GameMap(mapComponents);
    }

    public GameMap getGameMap(){
        return map;
    }
    public void addEntity(Entity entity) {
        entityMap.put(entity.getID(), entity);
    }

    public <E extends Entity> List<Entity> getEntities(Class<E>... entityTypes) {
        List<Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes) {
                if (entityType.equals(e.getClass())) {
                    r.add(e);
                }
            }
        }
        return r;

    }

    public Entity getEntity(String ID) {
        return entityMap.get(ID);
    }

    public void removeEntity(String entityID) {
        entityMap.remove(entityID);
    }

    public void removeEntity(Entity entity) {
        entityMap.remove(entity.getID());
    }
}
