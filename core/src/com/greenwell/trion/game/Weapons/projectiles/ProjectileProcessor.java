package com.greenwell.trion.game.Weapons.projectiles;

import com.greenwell.trion.Drawable;
import com.greenwell.trion.Updatable;
import com.greenwell.trion.engine.graphics.ShapeRenderer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ProjectileProcessor implements Updatable, Drawable {

    @Inject
    ShapeRenderer shapeMachine;

    public List<Projectile> projectiles = new ArrayList();

    public void addProjectile(Projectile projectile){
        if(projectile!=null)
            projectiles.add(projectile);
    }

    @Override
    public void update(float delta) {
        for(int i = 0; i < projectiles.size(); i ++){
            if(projectiles.get(i).isDead()){
                projectiles.remove(i);
            }
            else {
                projectiles.get(i).update(delta);
            }
        }
    }

    @Override
    public void draw() {
        for(int i = 0; i < projectiles.size(); i ++) {
           projectiles.get(i).draw(shapeMachine);
        }
    }
}
