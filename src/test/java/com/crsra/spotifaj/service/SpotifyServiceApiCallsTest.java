package com.crsra.spotifaj.service;

import com.crsra.spotifaj.model.AudioTrackSearchResult;
import com.crsra.spotifaj.model.SpotifyAuthorizationToken;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SpotifyServiceApiCallsTest {
    @Autowired
    private SpotifyAuthorizationService spotifyAuthorizationService;

    @Autowired
    private SpotifyServiceApiCalls spotifyServiceApiCalls;

    @Test
    public void test_creating_rest_template_for_token() {
        ResponseEntity<SpotifyAuthorizationToken> spotifyAuthorizationTokenResponseEntity = spotifyAuthorizationService.generateToken();

        SpotifyAuthorizationToken token = spotifyAuthorizationTokenResponseEntity.getBody();
        Assert.assertEquals(HttpStatus.OK, spotifyAuthorizationTokenResponseEntity.getStatusCode());
        Assert.assertNotNull(token);
        Assert.assertNotNull(token.getAccessToken());
        Assert.assertFalse(token.getAccessToken().isEmpty());
    }

//    @Test
//    public void test_search_artist_muse() {
//        ResponseEntity<String> spotifySearchResult = spotifyServiceApiCalls.searchArtist("Muse");
//        System.out.println(spotifySearchResult.getBody());
//
//        Assert.assertEquals(HttpStatus.OK, spotifySearchResult.getStatusCode());
//    }

    @Test
    public void test_search_track_running() {
        ResponseEntity<AudioTrackSearchResult> spotifySearchResult = spotifyServiceApiCalls.searchTrack("Running");
        System.out.println(spotifySearchResult.getBody());

        Assert.assertEquals(HttpStatus.OK, spotifySearchResult.getStatusCode());
    }
}