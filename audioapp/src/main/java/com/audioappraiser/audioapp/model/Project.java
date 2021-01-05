package com.audioappraiser.audioapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Objects;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String artist;
    private Double rating;
    private Integer reviews;
    private Date release_date;
    @Enumerated(EnumType.STRING)
    private AlbumType type;
    private String image;

//    @ManyToOne
//    @JoinColumn(name = "artist_id")
//    @JsonManagedReference
//    private Artist artist_obj;
    public Project(){}

    public Project(String name, String artist){
        this.setName(name);
        this.setArtist(artist);
    }

}