package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.PokemonMove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonMoveRepository extends JpaRepository<PokemonMove, Integer> {
    List<PokemonMove> findAllByPokemonId(long pokemonId);
}
