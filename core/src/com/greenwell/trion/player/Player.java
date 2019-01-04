package com.greenwell.trion.player;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.Updatable;
import shapes.ShapeRenderable;

import javax.inject.Inject;

public class Player implements ShapeRenderable, Updatable {

    private Vector2 position = new Vector2(100, 100);
    private Vector2 movement = new Vector2();

    private final float triangleHeight = 50;
    private final float triangleWidth = 30;

    private final float speed = 200;
    private final float maxSpeed = 4f;
    private final float slowRate = 10f;
    float deltaSpeed = 0;

    @Inject
    private PlayerController controller;

    @Inject
    private OrthographicCamera camera;

    //TODO fix this
    @Override
    public void render(ShapeRenderer renderer) {
        renderer.triangle(position.x - triangleWidth / 2, position.y - triangleHeight / 2,
                position.x, position.y + triangleHeight / 2,
                position.x + triangleWidth / 2, position.y - triangleHeight / 2);
    }

    @Override
    public void update(float delta) {
        movement.scl(1 - ( delta));
        deltaSpeed = delta * speed;
        controller.move(deltaSpeed, movement);
        //movement.limit(maxSpeed);
        position.add(movement);
    }
}