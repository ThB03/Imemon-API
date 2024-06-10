package com.imemon.imemon.api.responses;


import com.imemon.imemon.api.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TeamResponse {
    private int status;
    private String message;
    private List<Team> teams;
}
