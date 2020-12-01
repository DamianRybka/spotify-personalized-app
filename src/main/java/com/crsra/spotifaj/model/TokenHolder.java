package com.crsra.spotifaj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenHolder {
    private SpotifyAuthorizationToken token;
}
