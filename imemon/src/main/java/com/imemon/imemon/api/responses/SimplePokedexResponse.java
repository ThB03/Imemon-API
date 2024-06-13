package com.imemon.imemon.api.responses;


import com.imemon.imemon.api.classes.SimplePokedex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SimplePokedexResponse {
    private int status;
    private String message;
    private SimplePokedex pokedex;
}
