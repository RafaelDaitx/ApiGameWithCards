package com.rafael.repository;

import com.rafael.entity.Jogada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Jogada, Long> {
}
