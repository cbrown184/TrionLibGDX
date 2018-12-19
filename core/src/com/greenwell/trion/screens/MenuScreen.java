package com.greenwell.trion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import javax.inject.Inject;
import javax.inject.Named;

public class MenuScreen extends TrionScreen implements Screen {

    @Inject @Named("menuMusic") String menuMusic;

    @Override
    public void show() {
        musicPlayer.play(menuMusic).loop(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        musicPlayer.fadeOut(1000,0);
    }
}
