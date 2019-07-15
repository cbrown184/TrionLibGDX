package com.greenwell.trion.engine.components.reversetime;

import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.Updatable;
import lombok.Getter;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class TimePositionList implements Updatable {

    @Getter @Inject @Named ("timewarp.maxduration") long maxDuration;
    abstract public void add(Vector2 position);
    abstract public TimePosition last();
    abstract public TimePosition first();
    abstract public int size();
    abstract public TimePosition reversePosition();



}
