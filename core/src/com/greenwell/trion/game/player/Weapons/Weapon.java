package com.greenwell.trion.game.player.Weapons;

import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.game.player.Weapons.projectiles.Projectile;

public interface Weapon {
    public Projectile fire(Vector2 fireFromPosition);
}
