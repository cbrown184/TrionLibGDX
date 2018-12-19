package com.greenwell.trion.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import java.lang.management.GarbageCollectorMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StreamingMusicPlayer implements MusicPlayer {

    final ExecutorService musicPlayer = Executors.newSingleThreadExecutor();

    //TODO STOP METHOD
    //TODO PLAY QUEUE
    //TODO  Playing two tracks does not queue them - make interruptable music event queue
    private final int fadeIncrements = 100;
    Music music;

    @Override
    public MusicPlayer play(String soundFile) {
        musicPlayer.submit(() -> {
            startMusicAutoShutdown(soundFile);
        });
        return this;
    }

    @Override
    public MusicPlayer fadeOut(final long fadeTime, final long delay) {
        musicPlayer.submit(() -> {
            try {
                Thread.sleep(delay);
                float initialVolume = music.getVolume();
                for (int i = 0; i < fadeIncrements; i++) {
                    Thread.sleep(fadeTime / fadeIncrements);
                    music.setVolume(music.getVolume() - (initialVolume / fadeIncrements));
                }
                music.stop();
                music.dispose();
                System.out.println(music.isPlaying());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return this;
    }

    @Override
    public MusicPlayer loop(boolean loop) {
        musicPlayer.submit(() -> music.setLooping(loop));
        return this;
    }

    private void startMusicAutoShutdown(String soundFile) {
        music = Gdx.audio.newMusic(Gdx.files.internal(soundFile));
        music.play();
        music.setOnCompletionListener(Music::dispose);
    }
}
