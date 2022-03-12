package de.diskostu.demo.date4u.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * Learned: a class annotated with {@link Configuration} gets a generated proxy class at runtime. To change this
 * behaviour, we can set {@code @Configuration(proxyBeanMethods = false)}.
 */
@Configuration
@Slf4j
public class AppUuidConfig {

    @Bean
    public String getUuid() {
        final UUID uuid = UUID.randomUUID();
        log.info("UUID1: {}", uuid);

        return uuid.toString();
    }


    @Bean
    public String shorterUuid() {
        // because at runtime, this is a proxy class, the direct call to getUuid() does not call the real method, but
        // uses the 1-time-generated object from the context.
        final String shorterUuid = getUuid().substring(0, getUuid().length() / 2);
        log.info("shorterUuid: {}", shorterUuid);

        return shorterUuid;
    }
}
