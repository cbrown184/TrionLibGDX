package com.greenwell.trion.modules;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.greenwell.trion.entity.DrawableComponent;
import com.greenwell.trion.entity.PositionComponent;
import com.greenwell.trion.player.KeyBoardController;
import com.greenwell.trion.player.PlayerController;

public class GameModule extends AbstractModule {
    @Override
    protected void configure() {

        //Controller device
        bind(PlayerController.class).to(KeyBoardController.class);

        //Camera
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        bind(OrthographicCamera.class).toInstance(camera);

        //Entity engine
        Engine engine = new Engine();
        bind(Engine.class).toInstance(engine);
        bind(Family.class).annotatedWith(Names.named("drawable")).toInstance(Family.all(DrawableComponent.class).get());

        ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
        bind(new TypeLiteral<ComponentMapper<DrawableComponent>>() {}).toInstance(ComponentMapper.getFor(DrawableComponent.class));
        bind(new TypeLiteral<ComponentMapper<PositionComponent>>() {}).toInstance(ComponentMapper.getFor(PositionComponent.class));


    }
}
