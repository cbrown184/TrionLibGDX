package com.greenwell.trion.sound;

public interface MusicPlayer {
    public MusicPlayer play(String filePath);
    public MusicPlayer fadeOut(long fadeTime, long delay);
    public MusicPlayer loop(boolean loop);
}
