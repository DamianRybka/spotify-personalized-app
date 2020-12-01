package com.crsra.spotifaj.service;

import com.crsra.spotifaj.model.AudioTrack;
import com.crsra.spotifaj.repository.AudioTrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FavouritesService {
    private final AudioTrackRepository audioTrackRepository;

    public void save(AudioTrack track) {
        audioTrackRepository.save(track);
    }

    public List<AudioTrack> list() {
        List<AudioTrack> audioTracks = new ArrayList<>();
        audioTrackRepository.findAll().forEach(audioTracks::add);
        return audioTracks;
    }

}
