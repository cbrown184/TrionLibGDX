package com.greenwell.trion.controller;

import com.badlogic.gdx.math.Vector2;

public interface PlayerController {
    void getMovement(float deltaSpeed, Vector2 movement);
}
