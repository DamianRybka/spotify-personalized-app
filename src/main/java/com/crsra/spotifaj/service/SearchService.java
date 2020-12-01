package com.crsra.spotifaj.service;

import com.crsra.spotifaj.model.AudioTrack;
import com.crsra.spotifaj.model.AudioTrackSearchResult;
import com.crsra.spotifaj.model.SearchResult;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchService {
    private final SpotifyServiceApiCalls apiCalls;

    public SearchResult<AudioTrack> searchByTrack(String track, int offset) {
        ResponseEntity<AudioTrackSearchResult> searchTrackResults = apiCalls.searchTrack(track);

        return searchTrackResults.getBody().getTracks();
    }
}
