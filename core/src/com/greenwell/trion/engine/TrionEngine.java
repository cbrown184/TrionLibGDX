package com.greenwell.trion.engine;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;


public class TrionEngine extends Engine {
    public void init(EntitySystem... systems) {
        for(EntitySystem system: systems)
            addSystem(system);
    }
}
