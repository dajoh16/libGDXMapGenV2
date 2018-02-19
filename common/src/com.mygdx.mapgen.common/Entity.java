package com.mygdx.mapgen.common;

import com.mygdx.mapgen.common.EntityComponents.EntityComponent;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public class Entity {
    private final UUID ID = UUID.randomUUID();
    private Map<Class, EntityComponent> components;
    private float[] shapeX = new float[4]; //MAX OF FOUR VECTORS FOR SHAPE. Preferably dynamic
    private float[] shapeY = new float[4];

    public Entity() {
        components = new ConcurrentHashMap<>();
    }

    public String getID() {
        return ID.toString();
    }

    public void add(EntityComponent component) {
        components.put(component.getClass(), component);
    }

    public void remove(Class componentClass) {
        components.remove(componentClass);
    }

    public <E extends EntityComponent> E getPart(Class componentClass) {
        return (E) components.get(componentClass);
    }
    public float[] getShapeX() {
        return shapeX;
    }

    public void setShapeX(float[] shapeX) {
        this.shapeX = shapeX;
    }

    public float[] getShapeY() {
        return shapeY;
    }

    public void setShapeY(float[] shapeY) {
        this.shapeY = shapeY;
    }
}
