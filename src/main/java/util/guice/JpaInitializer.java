package util.guice;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This utility class initializes JPA.
 */
@Singleton
public class JpaInitializer {

    /**
     * Starts the persistence service.
     * @param persistService the persistence service
     */
    @Inject
    public JpaInitializer (PersistService persistService) {
        persistService.start();
    }

}