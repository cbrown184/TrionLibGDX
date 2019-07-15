package com.greenwell.trion.game.Weapons.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.ShapeMachineDrawable;
import com.greenwell.trion.Updatable;

public abstract class Projectile implements Updatable, ShapeMachineDrawable {
    protected Vector2 position = new Vector2();
    protected final long ttl;
    private final long timeCreated;

    protected Projectile(long ttl) {
        this.ttl = ttl;
        timeCreated = System.currentTimeMillis();
    }

    public boolean isDead(){
        return System.currentTimeMillis()-timeCreated>ttl;
    }
}
