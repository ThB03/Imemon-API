package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Pokemon;
import com.imemon.imemon.api.model.PokemonAbility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonAbilityRepository extends JpaRepository<PokemonAbility, Long> {
    List<PokemonAbility> findAllByPokemonId(long pokemonId);
}
