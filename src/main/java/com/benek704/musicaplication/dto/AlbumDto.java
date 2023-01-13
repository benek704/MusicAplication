package com.benek704.musicaplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private String performer;
    private String title;
    private LocalDate releaseDate;
    private Double totalLength;
}
