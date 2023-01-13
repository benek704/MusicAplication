package com.benek704.musicaplication.controller;

import com.benek704.musicaplication.dto.AlbumDto;
import com.benek704.musicaplication.dto.TrackDto;
import com.benek704.musicaplication.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<AlbumDto> getAlbums() {
        return albumService.getAlbums();
    }

    @GetMapping("/{id}")
    public List<TrackDto> getTracksByAlbumId(@PathVariable Long id) {
        return albumService.getTracksByAlbumId(id);
    }
}


