package com.audioappraiser.audioapp.creation_reqs;

import com.audioappraiser.audioapp.model.AlbumType;
import com.audioappraiser.audioapp.model.Artist;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectCreationRequest {
    private String name;
    private String artist;
    private Long artist_id;
    private Double rating;
    private Integer reviews;
    private Date release_date;
    private AlbumType type;
}
