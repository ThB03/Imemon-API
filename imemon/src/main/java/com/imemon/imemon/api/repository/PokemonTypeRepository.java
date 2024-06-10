package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonTypeRepository extends JpaRepository<PokemonType, Long> {
    List<PokemonType> findAllByPokemonId(long id);
}
