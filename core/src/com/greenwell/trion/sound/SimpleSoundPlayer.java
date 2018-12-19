package com.greenwell.trion.sound;

import com.badlogic.gdx.audio.Sound;

public class SimpleSoundPlayer implements SoundPlayer {

    @Override
    public void play(Sound sound) {
        sound.play();
    }
}
