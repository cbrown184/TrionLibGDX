package com.greenwell.trion.game.Weapons.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.ShapeMachineDrawable;
import com.greenwell.trion.engine.graphics.ShapeRenderer;

public class LineProjectile extends Projectile implements ShapeMachineDrawable {

    private final long movementSpeed = 3000;
    public LineProjectile(Vector2 startPosition, Vector2 size){
        super(10000);
        this.position.set(startPosition);
        this.size.set(size);
    }


    private Vector2 size = new Vector2();
    private Vector2 position2 = new Vector2();

    @Override
    public void update(float delta) {
        position.y += (movementSpeed*delta);
    }

    @Override
    public void draw(ShapeRenderer shapeMachine) {
        shapeMachine.renderLine(position, position2.set(position).add(size) );
    }
}
