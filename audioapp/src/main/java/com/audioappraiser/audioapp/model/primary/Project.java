package com.audioappraiser.audioapp.model.primary;

import com.audioappraiser.audioapp.model.primary.AlbumType;

import javax.persistence.*;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String artist;
    private Double rating;
    private Integer reviews;
    private Date release_date;
    @Enumerated(EnumType.STRING)
    private AlbumType type;
    private String image;

    public Project(){}

    public Project(String name, String artist){
        this.setName(name);
        this.setArtist(artist);
    }

}