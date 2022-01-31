package com.olivetti.finance.repository;

import com.olivetti.finance.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query(value="SELECT * FROM receita WHERE descricao= :descricao ", nativeQuery = true)
    Optional<List<Receita>> buscaDescricao(String descricao);
}
