package com.greenwell.trion.engine.components.reversetime;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
public class TimePositionLinkedList extends TimePositionList{

    @Getter
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
    public TimePosition reversePosition() {
        TimePosition position = timePositions.removeLast();
//
//        long nanoTime = System. - timeController.getReverseStartTime();
//        long time1 = timeController.getReverseStartTime() - position.getTime();
//
//        while (nanoTime < time1){
//            nanoTime = System.nanoTime() - timeController.getReverseStartTime();
//
//        }
//        long time2 =  timeController.getReverseStartTime() - timePositions.peekLast().getTime();
//
//        while (size() > 3 && ! (nanoTime > time1  && nanoTime < time2  )){
//             position = timePositions.removeLast();
//             time1 = timeController.getReverseStartTime() - position.getTime();
//             time2 =  timeController.getReverseStartTime() - timePositions.peekLast().getTime();
//
//        }
        return position;
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
