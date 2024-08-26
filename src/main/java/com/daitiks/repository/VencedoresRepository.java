package com.daitiks.repository;

import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Vencedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VencedoresRepository extends CrudRepository<Vencedores, Long> {}
