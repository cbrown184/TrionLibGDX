package com.greenwell.trion.engine.entitycomponents;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.engine.components.reversetime.TimePositionLinkedList;

public class PositionComponent implements Component {
    public Vector2 position = new Vector2();
    public TimePositionLinkedList timePositionLinkedList  = new TimePositionLinkedList();
}
