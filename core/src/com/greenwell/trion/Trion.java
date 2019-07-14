package com.greenwell.trion;

import com.badlogic.gdx.Game;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.greenwell.trion.game.screens.intro.IntroScreen;
import com.greenwell.trion.game.screens.stage.Dev;
import com.greenwell.trion.modules.*;
import com.greenwell.trion.util.PerformanceLogger;

public class Trion extends Game {

    @Override
    public void create() {
        PerformanceLogger.init(5);
        Injector injector = Guice.createInjector(
                new GraphicsModule(),
                new SoundModule(),
                new GameModule(this),
                new AssetsModule(),
                new PropertiesModule());
        Dev dev = new Dev();
        injector.injectMembers(dev);
        setScreen(dev);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
