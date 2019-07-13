package com.greenwell.trion.controller.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.greenwell.trion.controller.PlayerController;
import com.greenwell.trion.util.VectorUtil;

public class KeyBoardController implements PlayerController {

    Vector2 playerMovementInput = new Vector2();

    private boolean left(){
        return Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }

    private boolean right(){
        return Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }

    private boolean down(){
        return Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);
    }

    private boolean up(){
        return Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
    }
    @Override
    public Vector2 getMovementVector() {
        VectorUtil.clear(playerMovementInput);


        if (left() && !right()) {
            playerMovementInput.x = -1;
        }
        if (down() && !up()) {
            playerMovementInput.y = -1;
        }
        if (right() && !left()) {
            playerMovementInput.x = 1;
        }
        if (up() && !down()) {
            playerMovementInput.y = 1;
        }

        return playerMovementInput.nor();
    }

    @Override
    public boolean isReceivingMovementInput() {
        return playerMovementInput.len()>0f;
    }

    @Override
    public boolean isFiring() {
        return Gdx.input.isKeyPressed(Input.Keys.SPACE);
    }

    @Override
    public boolean selectMachineGun() {
        return Gdx.input.isKeyPressed(Input.Keys.NUM_1);
    }


}
