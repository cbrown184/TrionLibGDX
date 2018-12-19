package com.greenwell.trion.sound;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SoundModule extends AbstractModule {

    String menuMusic = "music/fogger.mp3";
    String level1music = "music/goinDownTheFastWay.mp3";

    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("menuMusic")).to(menuMusic);
        bindConstant().annotatedWith(Names.named("level1music")).to(level1music);
    }
}
