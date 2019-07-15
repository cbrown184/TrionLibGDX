package com.greenwell.trion.game.Weapons;

import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.game.Weapons.projectiles.LineProjectile;
import com.greenwell.trion.game.Weapons.projectiles.Projectile;

public class MachineGun implements Weapon{

    private int rateOfFire = 600;

    boolean cooldown = false;
    private int coolDownTime = 60000 / rateOfFire;
    private long timeLastFired;

    private final Vector2 lineSize = new Vector2(0, 20);

    @Override
    public Projectile fire(Vector2 fireFromPosition) {
        if(!cooldown){
            cooldown = true;
            timeLastFired = System.currentTimeMillis();
            return new LineProjectile(fireFromPosition, lineSize);
        }
        if(System.currentTimeMillis() - timeLastFired > coolDownTime){
            cooldown = false;
        }
        return null;
    }

}
