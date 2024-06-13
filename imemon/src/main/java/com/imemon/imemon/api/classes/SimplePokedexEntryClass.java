package com.imemon.imemon.api.classes;

import com.imemon.imemon.api.model.Pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimplePokedexEntryClass {
    private long id;
    private String name;
    private String image;

    public SimplePokedexEntryClass(Pokemon pokemon){
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.image = pokemon.getImage();
    }
}
