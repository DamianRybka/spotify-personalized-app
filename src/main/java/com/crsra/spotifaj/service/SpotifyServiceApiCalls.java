package com.crsra.spotifaj.service;

import com.crsra.spotifaj.SpotifyApi;
import com.crsra.spotifaj.component.HttpFrameComposer;
import com.crsra.spotifaj.model.AudioTrackSearchResult;
import com.crsra.spotifaj.model.SpotifyAuthorizationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.crsra.spotifaj.SpotifyApi.BASE_ACCOUNTS_URL;
import static com.crsra.spotifaj.SpotifyApi.BASE_API_URL;

@Slf4j
@Service
public class SpotifyServiceApiCalls {
    private final static int PAGE_SIZE = 20;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpFrameComposer composer;
//
//    public ResponseEntity<String> searchArtist(String artist) {
//        String composedUrl = BASE_API_URL + SpotifyApi.SEARCH_URL;
//        log.info("Composed url: " + composedUrl);
//        ResponseEntity<String> resp = restTemplate.exchange(composedUrl + artistSearch(artist), HttpMethod.GET, composer.getTokenEntity(), String.class);
//
//        return resp;
//    }
//
//    private String artistSearch(String artist) {
//        return "?q=" + artist + "&type=artist&limit=" + PAGE_SIZE;
//    }

    public ResponseEntity<AudioTrackSearchResult> searchTrack(String track) {
        String composedUrl = BASE_API_URL + SpotifyApi.SEARCH_URL;
        log.info("Composed url: " + composedUrl);
        ResponseEntity<AudioTrackSearchResult> resp = restTemplate.exchange(composedUrl + trackSearch(track), HttpMethod.GET, composer.getTokenEntity(), AudioTrackSearchResult.class);

        log.info(": " + resp.getBody());
        return resp;
    }

    private String trackSearch(String track) {
        return "?q=" + track + "&type=track";
    }
}
