package com.greenwell.trion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.greenwell.trion.Trion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DesktopLauncher {
	public static void main (String[] arg) throws IOException {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Properties props = new Properties();
		File file = new File("game.properties");
		props.load(new FileInputStream(file));
		config.height = Integer.parseInt(props.getProperty("config.height"));
		config.width = Integer.parseInt(props.getProperty("config.width"));
		config.vSyncEnabled = Boolean.parseBoolean(props.getProperty("config.vSyncEnabled"));
		config.foregroundFPS = Integer.parseInt(props.getProperty("config.foregroundFPS")); // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = Integer.parseInt(props.getProperty("config.backgroundFPS"));
		new LwjglApplication(new Trion(), config);
	}

}
