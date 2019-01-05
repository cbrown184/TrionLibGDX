package com.greenwell.trion.modules;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.google.inject.AbstractModule;
import com.greenwell.trion.rendering.shapes.ShapeMachine;

public class GraphicsModule  extends AbstractModule {
    @Override
    protected void configure() {
        //Camera
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        bind(OrthographicCamera.class).toInstance(camera);
        //Renderer
        bind(ShapeRenderer.class).asEagerSingleton();
        //Shapes
        bind(ShapeMachine.class).asEagerSingleton();
    }
}
