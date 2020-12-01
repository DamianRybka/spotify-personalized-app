package com.crsra.spotifaj.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AudioTrack {
    @Id
    private String id;

    private List<Artist> artists;
    private List<String> availableMarkets;
    private Integer discNumber;
    private Long durationMs;
    private Boolean explicit;
    private SpotifyLink externalUrls;
    private String href;
    private Boolean isLocal;
    private String name;
    private Integer popularity;
    private Integer trackNumber;
    private String type;
    private String uri;

    public String getArtistsString() {
        StringBuilder builder = new StringBuilder();
        artists.stream().forEach(artist -> builder.append(artist.getName()).append(", "));
        return builder.toString();
    }

}
