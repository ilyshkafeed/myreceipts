package com.githab.ilyshkafox.checkregistration.configuration;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JooqConfiguration {
    private final ConnectionFactory connectionFactory;

    @Bean(value = "r2dbcDSLContext")
    DSLContext createContext() {
        return DSL.using(connectionFactory);
    }
}
