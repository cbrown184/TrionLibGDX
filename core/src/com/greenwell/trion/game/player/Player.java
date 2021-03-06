package com.greenwell.trion.game.player;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.Drawable;
import com.greenwell.trion.Updatable;
import com.greenwell.trion.controller.PlayerController;
import com.greenwell.trion.engine.components.reversetime.TimeController;
import com.greenwell.trion.engine.entitySystems.MovementSystem;
import com.greenwell.trion.engine.entitycomponents.DrawableLineComponent;
import com.greenwell.trion.engine.entitycomponents.DrawableTriangleComponent;
import com.greenwell.trion.engine.entitycomponents.PositionComponent;
import com.greenwell.trion.engine.entitycomponents.VelocityComponent;
import com.greenwell.trion.engine.graphics.ShapeRenderer;

import javax.inject.Inject;
import javax.inject.Named;

public class Player implements Updatable, Drawable {

@Inject
private PlayerController controller;

    TimeController timeController;
    @Inject Engine engine;
    @Inject ShapeRenderer triangleRenderer;
    @Inject @Named ("player.acceleration") float acceleration;
    @Inject @Named ("player.maxspeed")int maxSpeed;
    @Inject @Named ("player.height") int height;
    @Inject @Named ("player.width") int width;
    @Inject @Named ("player.deceleration") float deceleration;

    @Inject
    MovementSystem movementSystem;

    private Entity entity = new Entity();
    private VelocityComponent velocityComponent;
    private PositionComponent positionComponent;
    private Vector2 accelerationVector = new Vector2();
    private Vector2 decelerationVector = new Vector2();
    private Vector2 position = new Vector2();

    @Inject
    public void init() {
        entity.add(new PositionComponent());
        entity.add(new VelocityComponent());
        entity.add(new DrawableTriangleComponent());
        engine.addEntity(entity);
        velocityComponent = entity.getComponent(VelocityComponent.class);
        positionComponent = entity.getComponent(PositionComponent.class);
        DrawableTriangleComponent drawableTriangleComponent = entity.getComponent(DrawableTriangleComponent.class);
        drawableTriangleComponent.height = height;
        drawableTriangleComponent.width = width;
        timeController = movementSystem.getTimeController();
       // deceleration %= 1000;
    }

    @Override
    public void update(float delta) {

        move(delta);
        if(!controller.isReversingTime() && timeController.isReversingTime()){
            timeController.setReversing(false);
        }
        else {
            if(controller.isReversingTime() && !timeController.isReversingTime()){
                timeController.setReversing(true);
            }
        }

        if(controller.isFiring()){
            Entity entity = new Entity();
            DrawableLineComponent dc = new DrawableLineComponent();
            VelocityComponent vc = new VelocityComponent();
            PositionComponent pc = new PositionComponent();

            dc.end = new Vector2(10, 30);
            vc.velocity.y = 4000;
            pc.position = new Vector2(positionComponent.position);

            entity.add(dc);
            entity.add(vc);
            entity.add(pc);
            engine.addEntity(entity);
        }


    }



    private void move(float delta){
        Vector2 direction = controller.getMovementVector();

        accelerationVector.set(direction);
        accelerationVector.scl(acceleration);

        velocityComponent.velocity.x += accelerationVector.x * delta;
        velocityComponent.velocity.y += accelerationVector.y * delta;

        velocityComponent.velocity.limit(maxSpeed);

        if (!controller.isReceivingMovementInput()) {
            decelerationVector.set(velocityComponent.velocity).scl(deceleration);
            velocityComponent.velocity.x -= decelerationVector.x * delta;
            velocityComponent.velocity.y -= decelerationVector.y * delta;
        }

     //   position = positionComponent.position;


    }

    @Override
    public void draw() {
        float triangleHeight = 25;
        float triangleWidth = 15;
        triangleRenderer.renderTriangle(positionComponent.position, triangleHeight, triangleWidth);
    }


    private void spin(float delta) {

//        boolean movingRight = direction.x > 0;
//        boolean movingleft = direction.x < 0;
//
//
//        if (movingRight) {
//
//            if (triangleWidth > 3) {
//                triangleWidth -= (delta * rotateSpeed) * (velocityComponent.velocity.x) / 1000;
//                triangleHeight += (delta * rotateSpeed) * (velocityComponent.velocity.x) / 1000;
//
//            }
//
//
//        } else if (movingleft) {
//
//            if (triangleWidth > 3) {
//                triangleWidth += (delta * rotateSpeed) * (velocityComponent.velocity.x / 1) / 1000;
//                triangleHeight -= (delta * rotateSpeed) * (velocityComponent.velocity.x / 1) / 1000;
//
//            }
//        } else {
//            if (triangleWidth < 15) {
//                triangleWidth += delta * rotateSpeed / 4;
//            }
//            if (triangleWidth > 15) {
//                triangleWidth = 15;
//            }
//
//            if (triangleHeight > 25) {
//                triangleHeight -= delta * rotateSpeed / 4;
//            }
//            if (triangleHeight < 25) {
//                triangleHeight = 25;
//            }
//        }
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