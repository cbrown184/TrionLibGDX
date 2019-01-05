package com.greenwell.trion.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class AssetsModule extends AbstractModule {

    private String libGdxLogo =     "images/badlogic-new.png";
    private String libGdxTxt =      "images/libGdxTxt.png";
    private String versionTxt =     "images/versionTxt.png";
    private String redMoon =        "images/redMoon.png";
    private String eatMyBallsTxt =  "images/eatMyBalls.png";
    private String rmgTxt =         "images/rmgTxt.png";
    private String redMoonTxt =     "images/redMoonTxt.png";

    String ps1 = "music/ps1.mp3";

    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("libGdxLogo")).to(libGdxLogo);
        bindConstant().annotatedWith(Names.named("libgdx198txt")).to(libGdxTxt);
        bindConstant().annotatedWith(Names.named("versionTxt")).to(versionTxt);
        bindConstant().annotatedWith(Names.named("redMoon")).to(redMoon);
        bindConstant().annotatedWith(Names.named("eatMyBallsTxt")).to(eatMyBallsTxt);
        bindConstant().annotatedWith(Names.named("rmgTxt")).to(rmgTxt);
        bindConstant().annotatedWith(Names.named("redMoonTxt")).to(redMoonTxt);
        bindConstant().annotatedWith(Names.named("ps1")).to(ps1);
    }
}
