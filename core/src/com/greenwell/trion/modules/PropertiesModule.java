package com.greenwell.trion.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PropertiesModule extends AbstractModule {
    @Override
    protected void configure() {
        Properties defaults = new Properties();
        try {
            Properties props = new Properties(defaults);
            File file = new File("game.properties");
            props.load(new FileInputStream(file));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            log.error("Could not load config: ", e);
            System.exit(1);
        }
    }
}
