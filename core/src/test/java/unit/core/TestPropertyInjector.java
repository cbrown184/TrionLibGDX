package unit.core;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestPropertyInjector {
    Properties props = new Properties();
    protected Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            Properties props = new Properties();
            props.setProperty("timewarp.maxduration", "100");
            Names.bindProperties(binder(), props);
        }
    });


    @BeforeAll

    public void setup () {
        injector.injectMembers(this);
    }
}
