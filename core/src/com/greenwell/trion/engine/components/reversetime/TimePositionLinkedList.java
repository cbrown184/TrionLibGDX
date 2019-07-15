package com.greenwell.trion.engine.components.reversetime;

import com.badlogic.gdx.math.Vector2;
import lombok.ToString;

import java.util.LinkedList;
public class TimePositionLinkedList extends TimePositionList{

    LinkedList<TimePosition> timePositions = new LinkedList<>();

    @Override
    public void add(Vector2 position) {
        timePositions.add(new TimePosition(position));
    }

    @Override
    public TimePosition first() {
        return timePositions.getFirst();
    }

    @Override
    public int size() {
        return timePositions.size();
    }

    @Override
    public TimePosition last() {
        return timePositions.getLast();
    }


    @Override
    public void update(float delta) {
        TimePosition timePosition = first();

        while ( last().time - first().time > maxDuration * 1000000){
            timePositions.removeFirst();
        }
        System.out.println(size());
    }

}
