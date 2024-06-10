package com.imemon.imemon.api.responses;


import com.imemon.imemon.api.classes.PokemonClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PokemonResponse {
    private int status;
    private String message;
    private PokemonClass pokemon;
}
