package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Pokemon findById(long id);
}
