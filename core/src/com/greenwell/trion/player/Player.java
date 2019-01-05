package com.greenwell.trion.player;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.Updatable;
import com.greenwell.trion.rendering.shapes.ShapeMachine;
import com.greenwell.trion.util.VectorUtil;

import javax.inject.Inject;

public class Player implements Updatable {

    private Vector2 position = new Vector2(100, 100);
    private Vector2 movement = new Vector2();

    private final float triangleHeight = 25;
    private final float triangleWidth = 15;

    private final float speed = 700;
    float deltaSpeed;

    @Inject
    private PlayerController controller;

    @Inject
    private OrthographicCamera camera;

    @Inject
    ShapeMachine triangleRenderer;

    @Override
    public void update(float delta) {
        deltaSpeed = delta * speed;
        VectorUtil.clear(movement);
        controller.getMovement(deltaSpeed, movement);
        position.add(movement);
        triangleRenderer.renderTriangle(position, triangleHeight, triangleWidth);
    }
}