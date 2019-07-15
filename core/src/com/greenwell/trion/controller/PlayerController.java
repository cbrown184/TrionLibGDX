package com.greenwell.trion.controller;

import com.badlogic.gdx.math.Vector2;

public interface PlayerController {
    Vector2 getMovementVector();
    boolean isReceivingMovementInput();
    boolean isFiring();
    boolean selectMachineGun();
    boolean isReversingTime();
}
