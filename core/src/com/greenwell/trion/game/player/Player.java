package com.greenwell.trion.game.player;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.Drawable;
import com.greenwell.trion.Updatable;
import com.greenwell.trion.controller.PlayerController;
import com.greenwell.trion.engine.entity.DrawableTriangleComponent;
import com.greenwell.trion.engine.entity.PositionComponent;
import com.greenwell.trion.engine.entity.VelocityComponent;
import com.greenwell.trion.engine.rendering.shapes.ShapeRenderer;
import com.greenwell.trion.game.player.Weapons.Weapon;
import com.greenwell.trion.game.player.Weapons.WeaponSelector;
import com.greenwell.trion.game.player.Weapons.projectiles.ProjectileProcessor;

import javax.inject.Inject;

public class Player implements Updatable, Drawable {

    @Inject
    ProjectileProcessor projectileProcessor;

    @Inject
    WeaponSelector weaponSelector;

    Weapon equippedWeapon;

    Entity entity = new Entity();

    @Inject
    Engine engine;

    @Inject
    public void init() {
        entity.add(new PositionComponent());
        entity.add(new VelocityComponent());
        entity.add(new DrawableTriangleComponent());
        engine.addEntity(entity);
        velocityComponent = entity.getComponent(VelocityComponent.class);
        positionComponent = entity.getComponent(PositionComponent.class);
        drawableTriangleComponent = entity.getComponent(DrawableTriangleComponent.class);
        drawableTriangleComponent.height = 25;
        drawableTriangleComponent.width = 15;
    }

    private float triangleHeight = 25;
    private float triangleWidth = 15;
    private final float speed = 3000;
    private final int maxSpeed = 500;
    private final int maxAcceleration = 10;
    private final int rotateSpeed = 50;


    private boolean rotateBounce = false;

    private Vector2 direction = new Vector2();


    private Vector2 position = new Vector2(100, 100);
    private Vector2 velocity = new Vector2();

    private VelocityComponent velocityComponent;
    private PositionComponent positionComponent;
    private DrawableTriangleComponent drawableTriangleComponent;
    private Vector2 acceleration = new Vector2();
    private Vector2 deceleration = new Vector2();


    @Inject
    private PlayerController controller;

    @Inject
    ShapeRenderer triangleRenderer;

    @Override
    public void update(float delta) {

        direction = controller.getMovementVector();

        acceleration.set(direction);
        acceleration.scl(speed);


        velocity.x += acceleration.x * delta;
        velocity.y += acceleration.y * delta;


        velocity.limit(maxSpeed);
        if (!controller.isReceivingMovementInput()) {
            deceleration.set(velocity).scl(3f);
            velocity.x -= deceleration.x * delta;
            velocity.y -= deceleration.y * delta;
        }
        velocityComponent.velocity = velocity;
    }


    @Override
    public void draw() {
        triangleRenderer.renderTriangle(position, triangleHeight, triangleWidth);
    }


    private void spin(float delta) {

        boolean movingRight = direction.x > 0;
        boolean movingleft = direction.x < 0;


        if (movingRight) {

            if (triangleWidth > 3) {
                triangleWidth -= (delta * rotateSpeed) * (velocity.x) / 1000;
                triangleHeight += (delta * rotateSpeed) * (velocity.x) / 1000;

            }


        } else if (movingleft) {

            if (triangleWidth > 3) {
                triangleWidth += (delta * rotateSpeed) * (velocity.x / 1) / 1000;
                triangleHeight -= (delta * rotateSpeed) * (velocity.x / 1) / 1000;

            }
        } else {
            if (triangleWidth < 15) {
                triangleWidth += delta * rotateSpeed / 4;
            }
            if (triangleWidth > 15) {
                triangleWidth = 15;
            }

            if (triangleHeight > 25) {
                triangleHeight -= delta * rotateSpeed / 4;
            }
            if (triangleHeight < 25) {
                triangleHeight = 25;
            }
        }
//
//        if(movingRight || movingleft) {
//            if (triangleWidth > 15) {
//                rotateBounce = !rotateBounce;
//            }
//            if (triangleWidth < 1) {
//                rotateBounce = !rotateBounce;
//            }
//            if (rotateBounce) {
//                triangleWidth -= (delta * rotateSpeed) * velocity.x / 1000;
//                triangleHeight += (delta * rotateSpeed) * velocity.x / 1000;
//            } else {
//                triangleWidth += (delta * rotateSpeed) * velocity.x / 1000;
//                triangleHeight -= (delta * rotateSpeed) * velocity.x / 1000;
//            }
//        } else {
//            if(triangleWidth<15){
//                triangleWidth+= delta * rotateSpeed/4;
//            }
//            if(triangleWidth>15){
//                triangleWidth  =15;
//            }
//
//            if(triangleHeight>25){
//                triangleHeight -= delta * rotateSpeed/4;
//            }
//            if(triangleHeight<25){
//                triangleHeight =  25;
//            }
//        }


    }
}