package com.greenwell.trion.modules;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.google.inject.AbstractModule;
import com.greenwell.trion.engine.TrionEngine;

import com.greenwell.trion.controller.impl.KeyBoardController;
import com.greenwell.trion.controller.PlayerController;
import com.greenwell.trion.engine.entitySystems.MovementSystem;
import com.greenwell.trion.engine.entitySystems.DrawingSystem;
import com.greenwell.trion.engine.graphics.ShapeRenderer;
import com.greenwell.trion.game.player.Player;
import com.greenwell.trion.game.Weapons.projectiles.ProjectileProcessor;

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


        bind(ProjectileProcessor.class).asEagerSingleton();
        bind(ShapeRenderer.class).asEagerSingleton();


        //Engine

        bind(Player.class).asEagerSingleton();
        MovementSystem movementSystem = new MovementSystem();
        DrawingSystem triangleDrawingSystem = new DrawingSystem();
        TrionEngine trionEngine = new TrionEngine();
        bind(DrawingSystem.class).toInstance(triangleDrawingSystem);
        trionEngine.init(movementSystem, triangleDrawingSystem);
        bind(Engine.class).toInstance(trionEngine);

    }
}
