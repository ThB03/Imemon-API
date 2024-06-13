package com.imemon.imemon.api.classes;

import com.imemon.imemon.api.model.Ability;
import com.imemon.imemon.api.model.Move;
import com.imemon.imemon.api.model.Pokemon;
import com.imemon.imemon.api.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonClass {
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
    private String flavor;
    private List<Type> types;
    private List<Ability> abilities;
    private List<Move> moves;

    public PokemonClass(Pokemon pokemon, List<Type> types, List<Ability> abilities, List<Move> moves) {
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
        this.flavor = pokemon.getFlavor();
        this.types = types;
        this.abilities = abilities;
        this.moves = moves;
    }
}
