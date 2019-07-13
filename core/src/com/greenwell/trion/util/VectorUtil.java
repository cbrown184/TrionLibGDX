package com.greenwell.trion.util;

import com.badlogic.gdx.math.Vector2;

public class VectorUtil {

    static Vector2 cache = new Vector2();

    public static void clear(Vector2 vector2){
        vector2.y = 0;
        vector2.x = 0;
    }

    public static Vector2 reverse(Vector2 vector2){
        cache.y = vector2.y * -1;
        cache.x = vector2.x * -1;
        return cache;
    }
}
