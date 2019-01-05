package com.greenwell.trion.rendering.shapes;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.google.inject.Inject;

public class ShapeMachine {

    @Inject
    ShapeRenderer shapeRenderer;

    public void renderTriangle(Vector2 position, float height, float width) {
        shapeRenderer.triangle(position.x - width, position.y - height,
                position.x, position.y + width,
                position.x + width, position.y - height);
    }
}
