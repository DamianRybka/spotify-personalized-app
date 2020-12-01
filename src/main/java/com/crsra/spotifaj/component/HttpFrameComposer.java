package com.crsra.spotifaj.component;

import com.crsra.spotifaj.model.SpotifyAuthorizationToken;
import com.crsra.spotifaj.model.TokenHolder;
import com.crsra.spotifaj.service.SpotifyAuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.crsra.spotifaj.SpotifyApi.SPOTIFY_CLIENT_ID;
import static com.crsra.spotifaj.SpotifyApi.SPOTIFY_CLIENT_SECRET;

@Slf4j
@Component
public class HttpFrameComposer {
    @Autowired
    private TokenHolder tokenHolder;
    @Autowired
    private SpotifyAuthorizationService spotifyAuthorizationService;

    public HttpEntity getAuthorizationEntity() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

        body.add("client_id", SPOTIFY_CLIENT_ID);
        body.add("client_secret", SPOTIFY_CLIENT_SECRET);
        body.add("grant_type", "client_credentials");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");

        return new HttpEntity(body, headers);
    }

    public HttpEntity getTokenEntity() {
        if(tokenHolder.getToken() == null){
            spotifyAuthorizationService.generateToken();
        }
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

        log.info("Token: " + tokenHolder.getToken().getAccessToken());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + tokenHolder.getToken().getAccessToken());

        return new HttpEntity(body, headers);
    }
}
