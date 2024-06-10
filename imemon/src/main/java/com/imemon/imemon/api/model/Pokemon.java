package com.imemon.imemon.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon")
public class Pokemon{
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "total")
    private long total;

    @Column(name = "hp")
    private long hp;

    @Column(name = "attack")
    private long attack;

    @Column(name = "defense")
    private long defense;

    @Column(name = "sp_att")
    private long spAtt;

    @Column(name = "sp_def")
    private long spDef;

    @Column(name = "speed")
    private long speed;
}