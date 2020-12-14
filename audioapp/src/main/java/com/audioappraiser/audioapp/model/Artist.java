package com.audioappraiser.audioapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;
import java.util.Objects;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "artists")
public class Artist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String alias;
    private Date birthdate;
    private String description;
//    @JsonBackReference
//        @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Project> projects;
}