package com.daitiks.repository;

import com.daitiks.entity.Vencedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VencedoresRepository extends JpaRepository<Vencedores, Long> {

    List<Vencedores> findByNomeVencedorOrderByIdDesc(String nomeVencedor);
}
