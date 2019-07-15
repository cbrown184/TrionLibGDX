package com.greenwell.trion.game.screens.intro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.greenwell.trion.game.screens.TrionScreen;
import com.greenwell.trion.game.screens.stage.Dev;
import com.greenwell.trion.util.PerformanceLogger;
import lombok.extern.slf4j.Slf4j;


import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
public class IntroScreen extends TrionScreen {
    private SpriteBatch batch;

    @Inject @Named("ps1.mp3") String menuMusic;
    @Inject
    Dev devScreen;
    @Inject @Named("badlogic-new.png")private String libGdxLogo;
    @Inject @Named("libGdxTxt.png")private String libgdx198txt;
    @Inject @Named("versionTxt.png")private String versionTxt;
    @Inject @Named("redMoon.png")private String redMoon;
    @Inject @Named("eatMyBalls.png")private String eatMyBallsTxt;
    @Inject @Named("rmgTxt.png")private String rmgTxt;
    @Inject @Named("redMoonTxt.png")private String redMoonTxt;

    BitmapFont font = new BitmapFont();
    Sprite libGdxLogoSprite;
    Sprite libgdx198txtSprite;
    Sprite versionTxtSprite;
    Sprite redMoonSprite;
    Sprite eatMyBallsTxtSprite;
    Sprite rmgTxtSprite;
    Sprite redMoonTxtSprite;

    @Inject
    OrthographicCamera camera;



    float red = 0.f, green = 0.f, blue = 0.f, alpha = 1.f, alpha2 = 0f, alpha3 = 0f;
    long startTime;
    @Override
    public void show() {
        font.setColor(new Color(0,0,0,1));
        libGdxLogoSprite = new Sprite(new Texture(Gdx.files.internal(libGdxLogo)));
        libgdx198txtSprite = new Sprite(new Texture(Gdx.files.internal(libgdx198txt)));
        versionTxtSprite = new Sprite(new Texture(Gdx.files.internal(versionTxt)));
        redMoonSprite = new Sprite(new Texture(Gdx.files.internal(redMoon)));
        eatMyBallsTxtSprite = new Sprite(new Texture(Gdx.files.internal(eatMyBallsTxt)));
        rmgTxtSprite = new Sprite(new Texture(Gdx.files.internal(rmgTxt)));
        redMoonTxtSprite = new Sprite(new Texture(Gdx.files.internal(redMoonTxt)));



        libgdx198txtSprite.setScale(0.3f, 0.5f);
        musicPlayer.play(menuMusic);
        startTime = System.currentTimeMillis();
        batch = new SpriteBatch();
        PerformanceLogger.init();
    }

    @Override
    public void render(float delta) {

        // I SHALT NOT BE JUDGED BY THIS CODE

        camera.update();
        long elapsedTime = (System.currentTimeMillis()-startTime);
        Gdx.gl.glClearColor(red, green, blue, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if((System.currentTimeMillis()-startTime)<2500){
            delta = delta/1.5f;
            red += delta; green += delta; blue += delta;
        }
       // batch.setProjectionMatrix(camera.combined);
        batch.begin();

        float x = 0.4f;
        float y = 0.4f;

        if(elapsedTime >1600 && elapsedTime < 7800 )
            batch.draw(libGdxLogoSprite,
                (Gdx.graphics.getWidth() - Gdx.graphics.getWidth()*x) / 2.0f,
                (Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*y) / 2.0f,
                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);


        x = 0.3f;
        y = 0.1f;
        if(elapsedTime>3700 && elapsedTime < 7800){
            batch.draw(libgdx198txtSprite,
                    (Gdx.graphics.getWidth() - Gdx.graphics.getWidth()*x) / 2.0f,
                    ((Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*y) / 2.0f) +
                            (Gdx.graphics.getHeight()*y) * 3,
                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);

            batch.draw(versionTxtSprite,
                    (Gdx.graphics.getWidth() - Gdx.graphics.getWidth()*x) / 2.0f,
                    ((Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*y) / 2.0f) -
                            (Gdx.graphics.getHeight()*y) * 3,
                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);
        }



        if(elapsedTime>6800 && elapsedTime < 7800){
            delta = delta * 2;
            red -= delta; green -= delta; blue -= delta;
            alpha = alpha <= 0.0f? 0.f : alpha - delta;
            batch.setColor(libGdxLogoSprite.getColor().r, libGdxLogoSprite.getColor().g, libGdxLogoSprite.getColor().b, alpha);
        }

        if(elapsedTime>7851 && elapsedTime < 8500) {
            delta = delta * 2;

            x = 0.75f/2;
            y = 0.75f/2;



          //  batch.draw(redMoonSprite, 100,100);

            alpha = alpha >= 1f? 1f : alpha + delta;
            batch.setColor(redMoonSprite.getColor().r, redMoonSprite.getColor().g, redMoonSprite.getColor().b, alpha);

            batch.draw(redMoonSprite,
                    (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()*x)) / 2.0f,
                    ((Gdx.graphics.getHeight() - (Gdx.graphics.getHeight()*y)) / 2.0f)+
                            (Gdx.graphics.getHeight()*0.2f),

                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);

        }

        if(elapsedTime>8500 && elapsedTime<14000){
            x = 0.75f/2;
            y = 0.75f/2;
            batch.setColor(redMoonSprite.getColor().r, redMoonSprite.getColor().g, redMoonSprite.getColor().b, 1f);

            batch.draw(redMoonSprite,
                    (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()*x)) / 2.0f,
                    ((Gdx.graphics.getHeight() - (Gdx.graphics.getHeight()*y)) / 2.0f)+
                            (Gdx.graphics.getHeight()*0.2f),

                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);


        }

        if(elapsedTime>8700 && elapsedTime<14000){

            x = 0.1f;
            y = 0.05f;
            alpha2 = alpha2 >= 1f? 1f : alpha2 + delta;
            batch.setColor(redMoonSprite.getColor().r, redMoonSprite.getColor().g, redMoonSprite.getColor().b, alpha2);




            batch.draw(eatMyBallsTxtSprite,
                    (Gdx.graphics.getWidth() - Gdx.graphics.getWidth()*x) / 2.0f,
                    ((Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*y) / 2.0f) -
                            (Gdx.graphics.getHeight()*y) * 8,
                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);

            x = 0.6f;
            y = 0.1f;

            batch.draw(rmgTxtSprite,
                    (Gdx.graphics.getWidth() - Gdx.graphics.getWidth()*x) / 2.0f,
                    ((Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*y) / 2.0f)-
                            (Gdx.graphics.getHeight()*0.05f) * 6,
                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);

        }

        if(elapsedTime>8800 && elapsedTime<14000){

            alpha3 = alpha3 >= 1f? 1f : alpha3 + delta;
            batch.setColor(redMoonSprite.getColor().r, redMoonSprite.getColor().g, redMoonSprite.getColor().b, alpha3);

            x = 0.4f;
            y = 0.2f;

            batch.draw(redMoonTxtSprite,
                    (Gdx.graphics.getWidth() - Gdx.graphics.getWidth()*x) / 2.0f,
                    ((Gdx.graphics.getHeight() - Gdx.graphics.getHeight()*y) / 2.0f)-
                            (Gdx.graphics.getHeight()*0.05f) * 2,
                    Gdx.graphics.getWidth()*x,
                    Gdx.graphics.getHeight()*y);

        }



            batch.end();

        if(elapsedTime>16000){
            game.setScreen(devScreen);
            dispose();
        }
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
        log.info("Dispose");
        font.dispose();
        libGdxLogoSprite.getTexture().dispose();
        libgdx198txtSprite.getTexture().dispose();
        versionTxtSprite.getTexture().dispose();
        redMoonSprite.getTexture().dispose();
        eatMyBallsTxtSprite.getTexture().dispose();
        rmgTxtSprite.getTexture().dispose();
        redMoonTxtSprite.getTexture().dispose();
    }
}
