package com.devsuperior.dslistbackendjoao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslistbackendjoao.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
