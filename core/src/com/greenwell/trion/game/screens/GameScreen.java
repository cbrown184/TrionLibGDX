package com.greenwell.trion.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.greenwell.trion.game.player.Player;

import javax.inject.Inject;

public abstract class GameScreen extends TrionScreen {

    @Inject
    protected Player player;


}
