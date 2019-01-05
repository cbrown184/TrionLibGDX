package com.greenwell.trion;

import com.badlogic.gdx.Game;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.greenwell.trion.modules.AssetsModule;
import com.greenwell.trion.modules.GameModule;
import com.greenwell.trion.modules.GraphicsModule;
import com.greenwell.trion.modules.SoundModule;
import com.greenwell.trion.screens.Dev;
import com.greenwell.trion.util.PerformanceLogger;

public class TrionLibGDX extends Game {

    @Override
    public void create() {
        PerformanceLogger.init(1);
        Injector injector = Guice.createInjector(
                new GraphicsModule(),
                new SoundModule(),
                new GameModule(this),
                new AssetsModule());
        setScreen(injector.getInstance(Dev.class));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
