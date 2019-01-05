package com.greenwell.trion.engine.sound;

public interface MusicPlayer {
    public MusicPlayer play(String filePath);
    public MusicPlayer fadeOut(long fadeTime, long delay);
    public MusicPlayer loop(boolean loop);
}
