package com.greenwell.trion.engine.entitySystems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.engine.components.reversetime.TimeController;
import com.greenwell.trion.engine.components.reversetime.TimePosition;
import com.greenwell.trion.engine.entitycomponents.PositionComponent;
import com.greenwell.trion.engine.entitycomponents.VelocityComponent;
import lombok.Getter;

import javax.inject.Inject;

public class MovementSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    @Getter
    TimeController timeController;

    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);
    @Inject
    public MovementSystem( TimeController timeController) {
        this.timeController = timeController;
    }

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    public void update(float deltaTime) {
        if (timeController.isReversingTime()) {
            for (int i = 0; i < entities.size(); ++i) {
                Entity entity = entities.get(i);
                PositionComponent position = pm.get(entity);
                if(position.timePositionLinkedList.size()>2){
                    TimePosition timePosition = position.timePositionLinkedList.reversePosition();
                    if(position.timePositionLinkedList.getTimePositions().isEmpty()){
                        timeController.setReversing(false);
                    }
                    position.position = timePosition.getPosition();
                }
                else {
                    entity.remove(PositionComponent.class);
                }
            }
        } else {
            for (int i = 0; i < entities.size(); ++i) {
                Entity entity = entities.get(i);
                PositionComponent position = pm.get(entity);
                VelocityComponent velocity = vm.get(entity);
                position.position.x += velocity.velocity.x * deltaTime;
                position.position.y += velocity.velocity.y * deltaTime;
                position.timePositionLinkedList.add(new Vector2(position.position));
            }
        }
    }
}
