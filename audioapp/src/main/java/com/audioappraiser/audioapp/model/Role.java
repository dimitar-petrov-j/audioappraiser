package com.audioappraiser.audioapp.model;

import javax.persistence.*;
import java.util.Set;

import lombok.Setter;
import lombok.Getter;


@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private com.audioappraiser.audioapp.model.ERole role;
}
