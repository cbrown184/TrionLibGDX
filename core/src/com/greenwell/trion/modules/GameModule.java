package com.greenwell.trion.modules;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Game;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.greenwell.trion.engine.entity.DrawableComponent;
import com.greenwell.trion.engine.entity.PositionComponent;
import com.greenwell.trion.controller.impl.KeyBoardController;
import com.greenwell.trion.controller.PlayerController;

public class GameModule extends AbstractModule {

    Game game;

    public GameModule(Game game) {
        this.game = game;
    }


    @Override
    protected void configure() {
        bind(Game.class).toInstance(game);

        //Controller device
        bind(PlayerController.class).to(KeyBoardController.class);

        //Entity engine
        Engine engine = new Engine();
        bind(Engine.class).toInstance(engine);
        bind(Family.class).annotatedWith(Names.named("drawable")).toInstance(Family.all(DrawableComponent.class).get());

        ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
        bind(new TypeLiteral<ComponentMapper<DrawableComponent>>() {}).toInstance(ComponentMapper.getFor(DrawableComponent.class));
        bind(new TypeLiteral<ComponentMapper<PositionComponent>>() {}).toInstance(ComponentMapper.getFor(PositionComponent.class));

    }
}
