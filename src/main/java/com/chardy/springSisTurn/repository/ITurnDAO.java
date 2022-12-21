package com.chardy.springSisTurn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chardy.springSisTurn.entity.Turn;

public interface ITurnDAO  extends JpaRepository<Turn, Long>{

}
