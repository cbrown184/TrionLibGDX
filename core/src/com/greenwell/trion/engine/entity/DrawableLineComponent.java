package com.greenwell.trion.engine.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class DrawableLineComponent implements Component {
    boolean onScreen = true;
    public Vector2 end;
}
