package com.greenwell.trion;

import com.badlogic.gdx.Game;
import com.google.inject.AbstractModule;
import com.greenwell.trion.sound.MusicPlayer;
import com.greenwell.trion.sound.StreamingMusicPlayer;

public class GameModule extends AbstractModule {

    private Game game;

    public GameModule(Game game) {
        this.game = game;
    }

    @Override
    protected void configure() {
        bind(Game.class).toInstance(game);
        bind(MusicPlayer.class).to(StreamingMusicPlayer.class).asEagerSingleton();
    }

}
