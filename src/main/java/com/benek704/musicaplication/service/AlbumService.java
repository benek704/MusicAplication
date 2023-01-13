package com.benek704.musicaplication.service;

import com.benek704.musicaplication.model.Album;
import com.benek704.musicaplication.dto.AlbumDto;
import com.benek704.musicaplication.model.Track;
import com.benek704.musicaplication.dto.TrackDto;
import com.benek704.musicaplication.repository.AlbumRepository;
import com.benek704.musicaplication.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final TrackRepository trackRepository;

    public AlbumService(AlbumRepository albumRepository, TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.trackRepository = trackRepository;
    }

    public List<AlbumDto> getAlbums() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream()
                .map(album -> {
                    List<Track> tracks = trackRepository.findAllByAlbumId(album.getId());
                    Double totalLength = tracks.stream().mapToDouble(Track::getDuration).sum();
                    return new AlbumDto(album.getPerformer(), album.getTitle(), album.getReleaseDate(), totalLength);
                })
                .collect(Collectors.toList());
    }

    public List<TrackDto> getTracksByAlbumId(Long id) {
        List<Track> tracks = trackRepository.findAllByAlbumId(id);
        return tracks.stream().map(track -> new TrackDto(track.getTitle(), track.getDuration())).collect(Collectors.toList());
    }
}
