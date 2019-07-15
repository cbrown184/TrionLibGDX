package com.greenwell.trion.engine.components.reversetime;

import com.badlogic.gdx.math.Vector2;
import lombok.Data;
import lombok.Getter;

@Data
public class TimePosition implements Comparable<TimePosition> {
    @Getter Vector2 position;
    @Getter final long time;

    public TimePosition(Vector2 position) {
        this.position = position;
        this.time = System.nanoTime();
    }

    @Override
    public int compareTo(TimePosition o) {
        return this.time - o.time > 0 ? 1 : -1;
    }
}
