package unit.core;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.Properties;

public class TimeWarpTestsModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties props = new Properties();
        props.setProperty("timewarp.maxduration", "100");
        Names.bindProperties(binder(), props);
    }

}
