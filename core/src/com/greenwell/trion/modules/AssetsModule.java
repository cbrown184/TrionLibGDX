package com.greenwell.trion.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class AssetsModule extends AbstractModule {

    @Override
    protected void configure() {
        log.info("Discovering assets.");
        File folder = new File("assets");
        bindAssets(folder);
    }

    public void bindAssets(File folder) {
        File[] files = folder.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                log.info("Found:" + files[i].getAbsolutePath());
                bindConstant().annotatedWith(Names.named(files[i].getName())).to(files[i].getAbsolutePath());
            } else if (files[i].isDirectory()) {
                bindAssets(files[i]);
            }
        }
    }
}
