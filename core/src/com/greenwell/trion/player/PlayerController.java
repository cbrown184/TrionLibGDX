package com.greenwell.trion.player;

import com.badlogic.gdx.math.Vector2;

public interface PlayerController {
    public void getMovement(float deltaSpeed, Vector2 movement);
}
