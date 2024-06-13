package com.imemon.imemon.api.requests;

import com.imemon.imemon.api.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeamRequest {
    private String Session;
    private String username;
    private String teamName;
    private Team team;
}
