package com.imemon.imemon.api.classes;

import com.imemon.imemon.api.model.Pokemon;
import com.imemon.imemon.api.model.Type;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokedexEntryClass {
    private long id;
    private String name;
    private String image;
    private long total;
    private long hp;
    private long attack;
    private long defense;
    private long spAtt;
    private long spDef;
    private long speed;
    private List<Type> types;

    public PokedexEntryClass(Pokemon pokemon, List<Type> types){
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.image = pokemon.getImage();
        this.total = pokemon.getTotal();
        this.hp = pokemon.getHp();
        this.attack = pokemon.getAttack();
        this.defense = pokemon.getDefense();
        this.spAtt = pokemon.getSpAtt();
        this.spDef = pokemon.getSpDef();
        this.speed = pokemon.getSpeed();
        this.types = types;
    }
}
