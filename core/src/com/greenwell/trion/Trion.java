package com.greenwell.trion;

import com.badlogic.gdx.Game;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.greenwell.trion.screens.Level1Screen;
import com.greenwell.trion.screens.MenuScreen;
import com.greenwell.trion.screens.ScreenModule;
import com.greenwell.trion.sound.SoundModule;

public class Trion extends Game {

    @Override
    public void create() {
        Injector injector = Guice.createInjector(
                new GameModule(this),
                new SoundModule(),
                new ScreenModule());
        setScreen(injector.getInstance(Level1Screen.class));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
