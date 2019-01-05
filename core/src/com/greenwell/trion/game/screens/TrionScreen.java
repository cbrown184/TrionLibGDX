package com.greenwell.trion.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.greenwell.trion.engine.sound.MusicPlayer;

import javax.inject.Inject;

public abstract class TrionScreen implements Screen {
    @Inject
    protected Game game;
    @Inject
    protected MusicPlayer musicPlayer;
    @Inject
    protected ShapeRenderer shapeRenderer;
}
