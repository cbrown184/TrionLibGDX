package com.greenwell.trion.engine.entitycomponents;

import com.badlogic.ashley.core.Component;

public class DrawableTriangleComponent implements Component {
    public boolean onScreen = true;
    public float height;
    public float width;
}
