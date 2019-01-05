import com.google.inject.Inject;
import org.json.JSONObject;

import java.util.Arrays;

public class Configurator {
    protected static <T> T jsonConfigure(JSONObject config, T t) {
        Arrays.stream(t.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(Inject.class) == null && field.getAnnotation(NonConfigurable.class) == null)
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        field.set(t, config.get(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return t;
    }
}