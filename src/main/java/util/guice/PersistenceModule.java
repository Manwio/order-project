package util.guice;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * This class represents a persistence module.
 */
public class PersistenceModule extends AbstractModule {

    private String jpaUnit;

    /**
     * Initializes an object with the {@code jpaUnit} variable.
     * @param jpaUnit the {@code jpaUnit} variable.
     */
    public PersistenceModule(String jpaUnit) {
        this.jpaUnit = jpaUnit;
    }

    @Override
    protected void configure() {
        install(new JpaPersistModule(jpaUnit));
        bind(JpaInitializer.class).asEagerSingleton();
    }

}