package com.imemon.imemon.api.responses;


import com.imemon.imemon.api.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private int status;
    private String message;
    private String username;
    private String session;
}
