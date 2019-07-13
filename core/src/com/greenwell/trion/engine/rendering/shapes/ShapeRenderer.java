package com.greenwell.trion.engine.rendering.shapes;

import com.badlogic.gdx.math.Vector2;
import com.google.inject.Inject;
import lombok.Getter;


public class ShapeRenderer {

    @Getter
    @Inject
    com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer;

    public void renderTriangle(Vector2 position, float height, float width) {
        shapeRenderer.triangle(position.x - width, position.y - height,
                position.x, position.y + width,
                position.x + width, position.y - height);
    }

    public void renderLine(Vector2 positionx, Vector2 positiony) {
        shapeRenderer.line(positionx, positiony);
    }
}
