package com.crsra.spotifaj.service;

import com.crsra.spotifaj.SpotifyApi;
import com.crsra.spotifaj.component.HttpFrameComposer;
import com.crsra.spotifaj.model.SpotifyAuthorizationToken;
import com.crsra.spotifaj.model.TokenHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.crsra.spotifaj.SpotifyApi.BASE_ACCOUNTS_URL;

@Slf4j
@Service
public class SpotifyAuthorizationService {
    @Autowired
    private HttpFrameComposer composer;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TokenHolder tokenHolder;

    public ResponseEntity<SpotifyAuthorizationToken> generateToken() {
        String composedUrl = BASE_ACCOUNTS_URL + SpotifyApi.TOKEN_URL;
        log.info("Composed url: " + composedUrl);
        // 1 parametr  - url
        // 2 metoda
        // 3 ramka autoryzująca
        ResponseEntity<SpotifyAuthorizationToken> resp = restTemplate.exchange(composedUrl, HttpMethod.POST, composer.getAuthorizationEntity(), SpotifyAuthorizationToken.class);
        log.info(resp.getBody().toString());
        if (resp.getStatusCode() == HttpStatus.OK) {
            SpotifyAuthorizationToken token = resp.getBody();
            tokenHolder.setToken(token);
        }
        return resp;
    }


}
