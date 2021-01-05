package com.audioappraiser.audioapp.creationreqs;

import com.audioappraiser.audioapp.model.AlbumType;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectCreationRequest {
    private String name;
    private String artist;
    private Double rating;
    private Integer reviews;
    private Date release_date;
    private AlbumType type;
    private String image;
}
