package com.audioappraiser.audioapp.model.secondary;

import javax.persistence.*;

import com.audioappraiser.audioapp.model.secondary.ERole;
import lombok.Setter;
import lombok.Getter;


@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole role;
}
