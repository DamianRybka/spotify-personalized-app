package com.crsra.spotifaj.configuration;

import com.crsra.spotifaj.SpotifyApi;
import com.crsra.spotifaj.model.SpotifyAuthorizationToken;
import com.crsra.spotifaj.model.TokenHolder;
import org.apache.commons.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BasicConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TokenHolder getToken(){
        return new TokenHolder();
    }
}