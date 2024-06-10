package com.imemon.imemon.api.responses;


import com.imemon.imemon.api.model.Move;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MoveResponse {
    private int status;
    private String message;
    private List<Move> moves;
}
