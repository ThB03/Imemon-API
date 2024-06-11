package com.imemon.imemon.api.model;

import com.imemon.imemon.api.requests.TeamRequest;
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

    public Team(TeamRequest teamRequest) {
        this.username = teamRequest.getUsername();
        this.teamName = teamRequest.getTeamName();
        this.poke1 = teamRequest.getPoke1();
        this.move11 = teamRequest.getMove11();
        this.move12 = teamRequest.getMove12();
        this.move13 = teamRequest.getMove13();
        this.move14 = teamRequest.getMove14();
        this.poke2 = teamRequest.getPoke2();
        this.move21 = teamRequest.getMove21();
        this.move22 = teamRequest.getMove22();
        this.move23 = teamRequest.getMove23();
        this.move24 = teamRequest.getMove24();
        this.poke3 = teamRequest.getPoke3();
        this.move31 = teamRequest.getMove31();
        this.move32 = teamRequest.getMove32();
        this.move33 = teamRequest.getMove33();
        this.move34 = teamRequest.getMove34();
        this.poke4 = teamRequest.getPoke4();
        this.move41 = teamRequest.getMove41();
        this.move42 = teamRequest.getMove42();
        this.move43 = teamRequest.getMove43();
        this.move44 = teamRequest.getMove44();
        this.poke5 = teamRequest.getPoke5();
        this.move51 = teamRequest.getMove51();
        this.move52 = teamRequest.getMove52();
        this.move53 = teamRequest.getMove53();
        this.move54 = teamRequest.getMove54();
        this.poke6 = teamRequest.getPoke6();
        this.move61 = teamRequest.getMove61();
        this.move62 = teamRequest.getMove62();
        this.move63 = teamRequest.getMove63();
        this.move64 = teamRequest.getMove64();
    }
}
