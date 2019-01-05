package com.greenwell.trion.modules;

import com.google.inject.AbstractModule;
import com.greenwell.trion.engine.sound.MusicPlayer;
import com.greenwell.trion.engine.sound.StreamingMusicPlayer;

public class SoundModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MusicPlayer.class).to(StreamingMusicPlayer.class).asEagerSingleton();
    }
}
