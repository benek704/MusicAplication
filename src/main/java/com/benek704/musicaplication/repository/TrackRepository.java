package com.benek704.musicaplication.repository;

import com.benek704.musicaplication.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findAllByAlbumId(Long id);
}

