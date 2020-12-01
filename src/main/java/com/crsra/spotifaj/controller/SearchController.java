package com.crsra.spotifaj.controller;

import com.crsra.spotifaj.model.AudioTrack;
import com.crsra.spotifaj.model.AudioTrackSearchResult;
import com.crsra.spotifaj.model.SearchResult;
import com.crsra.spotifaj.service.FavouritesService;
import com.crsra.spotifaj.service.SearchService;
import com.crsra.spotifaj.service.SpotifyServiceApiCalls;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/search/")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;
    private final FavouritesService favouritesService;

    @GetMapping(path = "/tracks")
    public String searchTracks(Model model,
                               @RequestParam(name = "q", required = false) String phrase,
                               @RequestParam(name = "page", defaultValue = "0") int page) {
        if (phrase != null && !phrase.isEmpty()) {
            SearchResult<AudioTrack> searchResult = searchService.searchByTrack(phrase, page);
            model.addAttribute("favourites", favouritesService.list().stream().map(AudioTrack::getId).collect(Collectors.toList()));
            model.addAttribute("q", phrase);
            model.addAttribute("tracks", searchResult);
        }
        return "track-list";
    }

    @PostMapping("/addfavourite")
    public String addfavourite(String q, AudioTrack track) {
        favouritesService.save(track);

        return "redirect:/search/tracks?q=" + q;
    }
}
