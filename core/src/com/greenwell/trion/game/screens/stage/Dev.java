package com.greenwell.trion.game.screens.stage;

import com.badlogic.ashley.core.Engine;
import com.greenwell.trion.game.screens.GameScreen;

import javax.inject.Inject;


public class Dev extends GameScreen {


//    @Inject
//    ProjectileProcessor projectileProcessor;

    @Inject
    Engine engine;

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        camera.update();
//        shapeRenderer.setProjectionMatrix(camera.combined);
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        //player.draw();
//        projectileProcessor.draw();
//        shapeRenderer.end();
//        projectileProcessor.update(delta);
        player.update(delta);
        engine.update(delta);


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
