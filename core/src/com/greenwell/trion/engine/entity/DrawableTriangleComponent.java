package com.greenwell.trion.engine.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class DrawableTriangleComponent implements Component {
    public boolean onScreen = true;
    public float height;
    public float width;
}
