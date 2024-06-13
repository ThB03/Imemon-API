package com.imemon.imemon.api.controller;


import com.imemon.imemon.api.classes.*;
import com.imemon.imemon.api.model.*;
import com.imemon.imemon.api.repository.*;
import com.imemon.imemon.api.responses.MoveResponse;
import com.imemon.imemon.api.responses.PokedexResponse;
import com.imemon.imemon.api.responses.PokemonResponse;
import com.imemon.imemon.api.responses.SimplePokedexResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokedexController {
    private PokemonRepository pokemonRepository;
    private PokemonMoveRepository pokemonMoveRepository;
    private MoveRepository moveRepository;
    private AbilityRepository abilityRepository;
    private PokemonAbilityRepository pokemonAbilityRepository;
    private PokemonTypeRepository pokemonTypeRepository;
    private TypeRepository typeRepository;



    public PokedexController(
            PokemonRepository pokemonRepository,
            PokemonMoveRepository pokemonMoveRepository,
            MoveRepository moveRepository,
            AbilityRepository abilityRepository,
            PokemonAbilityRepository pokemonAbilityRepository,
            PokemonTypeRepository pokemonTypeRepository,
            TypeRepository typeRepository
    ) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMoveRepository = pokemonMoveRepository;
        this.moveRepository = moveRepository;
        this.abilityRepository = abilityRepository;
        this.pokemonAbilityRepository = pokemonAbilityRepository;
        this.pokemonTypeRepository = pokemonTypeRepository;
        this.typeRepository = typeRepository;
    }

    @GetMapping("/pokedex")
    public PokedexResponse getPokedex() {
        try {
            List<PokedexEntryClass> pokedexEntries = new ArrayList<>();
            List<Pokemon> pokemonList = pokemonRepository.findAll();
            for (Pokemon pokemon : pokemonList) {

                List<PokemonType> typeList = pokemonTypeRepository.findAllByPokemonId(pokemon.getId());
                List<Type> pokemonTypes = new ArrayList<>();
                for (PokemonType pokemonType : typeList) {
                    pokemonTypes.add(typeRepository.findById(pokemonType.getTypeId()));
                }
                PokedexEntryClass pokedexEntry = new PokedexEntryClass(pokemon, pokemonTypes);
                pokedexEntries.add(pokedexEntry);
            }

            return new PokedexResponse(200, "", new Pokedex(pokedexEntries));
        }
        catch(Exception e) {
            return new PokedexResponse(500, "server error", null);
        }
    }

    @GetMapping("/pokedex/{id}")
    public PokemonResponse getPokemon(@PathVariable long id) {
        try {
            Pokemon pokemon = pokemonRepository.findById(id);
            List<PokemonMove> pokemonMoves = pokemonMoveRepository.findAllByPokemonId(id);
            List<PokemonType> pokemonTypes = pokemonTypeRepository.findAllByPokemonId(id);
            List<PokemonAbility> pokemonAbilities = pokemonAbilityRepository.findAllByPokemonId(id);

            List<Move> moves = new ArrayList<>();
            List<Ability> abilities = new ArrayList<>();
            List<Type> types = new ArrayList<>();

            for (PokemonMove pokemonMove : pokemonMoves) {
                moves.add(moveRepository.findById(pokemonMove.getMoveId()));
            }
            for (PokemonAbility pokemonAbility : pokemonAbilities) {
                abilities.add(abilityRepository.findById(pokemonAbility.getAbilityId()));
            }
            for (PokemonType pokemonType : pokemonTypes) {
                types.add(typeRepository.findById(pokemonType.getTypeId()));
            }
            return new PokemonResponse(200, "success", new PokemonClass(pokemon, types, abilities, moves));
        }
        catch(Exception e) {
            return new PokemonResponse(500, "server error", null);
        }

    }

    @GetMapping("pokedex/movesByPokemon/{id}")
    public MoveResponse getMoves(@PathVariable int id) {
        try{
            List<Move> moves = new ArrayList<>();
            List<PokemonMove> skillList = pokemonMoveRepository.findAllByPokemonId(id);
            for (PokemonMove pokemonMove: skillList) {
                moves.add(moveRepository.findById(pokemonMove.getMoveId()));
            }
            return new MoveResponse(200, "success", moves);
        }
        catch(Exception e) {
            return new MoveResponse(500, "server error", null);
        }
    }

    @GetMapping("/pokedex/simple")
    public SimplePokedexResponse getSimplePokedex() {
        try {
            List<SimplePokedexEntryClass> pokedexEntries = new ArrayList<>();
            List<Pokemon> pokemonList = pokemonRepository.findAll();
            for (Pokemon pokemon : pokemonList) {
                SimplePokedexEntryClass pokedexEntry = new SimplePokedexEntryClass(pokemon);
                pokedexEntries.add(pokedexEntry);
            }

            return new SimplePokedexResponse(200, "", new SimplePokedex(pokedexEntries));
        }
        catch(Exception e) {
            return new SimplePokedexResponse(500, "server error", null);
        }
    }

}