package com.daitiks.repository;

import com.daitiks.entity.Jogadores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadoresRepository extends CrudRepository<Jogadores, Long> {}
