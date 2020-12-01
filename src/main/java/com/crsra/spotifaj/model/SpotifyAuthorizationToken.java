package com.crsra.spotifaj.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SpotifyAuthorizationToken {
    private String accessToken; // access_token
    private String tokenType; // token_type
    private Integer expiresIn; // expiers_in
    private String scope; //scope

}
