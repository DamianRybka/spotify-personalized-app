package com.crsra.spotifaj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.crsra.spotifaj.repository")
@EnableTransactionManagement
public class SpotifajApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotifajApplication.class, args);
    }

}
