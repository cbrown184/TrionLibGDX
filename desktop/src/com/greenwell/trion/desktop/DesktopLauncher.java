package com.greenwell.trion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.greenwell.trion.TrionLibGDX;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("logback.configurationFile", "/Users/crez/Downloads/test/logback.xml");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1080;
		config.width = 1920;
		config.vSyncEnabled = false; // Setting to false disables vertical sync
		config.foregroundFPS = 60; // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = 60;
		new LwjglApplication(new TrionLibGDX(), config);
	}
}
