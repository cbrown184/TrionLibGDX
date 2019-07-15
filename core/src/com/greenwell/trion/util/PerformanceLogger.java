package com.greenwell.trion.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PerformanceLogger {

    public static void init(){
        init(5);
    }

    public static void init(int seconds){
        Runnable helloRunnable = new Runnable() {
            public void run() {
                log.info("Java memory use MB ~ Heap:" + Gdx.app.getJavaHeap()/1000000+ " Native:" + Gdx.app.getNativeHeap()/1000000);
                log.info("FPS "+ Gdx.graphics.getFramesPerSecond());
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, seconds, TimeUnit.SECONDS);
    }
}
