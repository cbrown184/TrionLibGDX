package com.greenwell.trion.engine.entitySystems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.greenwell.trion.engine.entity.DrawableLineComponent;
import com.greenwell.trion.engine.entity.DrawableTriangleComponent;
import com.greenwell.trion.engine.entity.PositionComponent;
import com.greenwell.trion.engine.rendering.shapes.ShapeRenderer;

import javax.inject.Inject;

public class DrawingSystem extends EntitySystem {

    @Inject
    ShapeRenderer shapeMachine;
    @Inject
    protected OrthographicCamera camera;

    private ImmutableArray<Entity> triangles;
    private ImmutableArray<Entity> lines;
    private final ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private final ComponentMapper<DrawableTriangleComponent> triangleMapper = ComponentMapper.getFor(DrawableTriangleComponent.class);
    private final ComponentMapper<DrawableLineComponent> lineMapper = ComponentMapper.getFor(DrawableLineComponent.class);

    //Cache
    private Entity entity;
    private PositionComponent position;
    private DrawableTriangleComponent triangleComponent;
    private DrawableLineComponent lineComponent;

    public void addedToEngine(Engine engine) {
        triangles = engine.getEntitiesFor(Family.all(PositionComponent.class, DrawableTriangleComponent.class).get());
        lines = engine.getEntitiesFor(Family.all(PositionComponent.class, DrawableLineComponent.class).get());
    }


    public void update(float deltaTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        shapeMachine.getShapeRenderer().setProjectionMatrix(camera.combined);
        shapeMachine.getShapeRenderer().begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line);

        for (int i = 0; i < triangles.size(); ++i) {
            entity = triangles.get(i);
            position = pm.get(entity);
            triangleComponent = triangleMapper.get(entity);
            if(triangleComponent.onScreen){
                shapeMachine.renderTriangle(position.position, triangleComponent.height, triangleComponent.width);
            }

        }

        for (int i = 0; i < lines.size(); ++i) {
            entity = lines.get(i);
            position = pm.get(entity);
            lineComponent = lineMapper.get(entity);
            if(lineComponent.onScreen){
                shapeMachine.renderLine(position.position, lineComponent.end);
            }
        }

        shapeMachine.getShapeRenderer().end();

    }


}
