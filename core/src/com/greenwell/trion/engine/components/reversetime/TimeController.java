package com.greenwell.trion.engine.components.reversetime;

import lombok.Data;
import lombok.Getter;

public class TimeController {
    public void setReversing(boolean isReversingTime){
        this.reverseStartTime = System.nanoTime();
        this.isReversingTime = isReversingTime;
    }
    @Getter
    long reverseStartTime;
    @Getter
    boolean isReversingTime = false;
}
