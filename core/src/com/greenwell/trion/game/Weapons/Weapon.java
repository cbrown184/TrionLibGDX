package com.greenwell.trion.game.Weapons;

import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.game.Weapons.projectiles.Projectile;

public interface Weapon {
    public Projectile fire(Vector2 fireFromPosition);
}
