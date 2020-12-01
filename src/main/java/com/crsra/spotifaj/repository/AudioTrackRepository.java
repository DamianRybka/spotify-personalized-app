package com.crsra.spotifaj.repository;

import com.crsra.spotifaj.model.AudioTrack;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AudioTrackRepository extends Neo4jRepository<AudioTrack, Long> {
}
