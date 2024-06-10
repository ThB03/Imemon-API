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
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user")
    private String username;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "poke1")
    private long poke1;

    @Column(name = "move11")
    private long move11;

    @Column(name = "move12")
    private long move12;

    @Column(name = "move13")
    private long move13;

    @Column(name = "move14")
    private long move14;

    @Column(name = "poke2")
    private long poke2;

    @Column(name = "move21")
    private long move21;

    @Column(name = "move22")
    private long move22;

    @Column(name = "move23")
    private long move23;

    @Column(name = "move24")
    private long move24;

    @Column(name = "poke3")
    private long poke3;

    @Column(name = "move31")
    private long move31;

    @Column(name = "move32")
    private long move32;

    @Column(name = "move33")
    private long move33;

    @Column(name = "move34")
    private long move34;

    @Column(name = "poke4")
    private long poke4;

    @Column(name = "move41")
    private long move41;

    @Column(name = "move42")
    private long move42;

    @Column(name = "move43")
    private long move43;

    @Column(name = "move44")
    private long move44;

    @Column(name = "poke5")
    private long poke5;

    @Column(name = "move51")
    private long move51;

    @Column(name = "move52")
    private long move52;

    @Column(name = "move53")
    private long move53;

    @Column(name = "move54")
    private long move54;

    @Column(name = "poke6")
    private long poke6;

    @Column(name = "move61")
    private long move61;

    @Column(name = "move62")
    private long move62;

    @Column(name = "move63")
    private long move63;

    @Column(name = "move64")
    private long move64;
}
