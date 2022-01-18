package com.cristhiane.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristhiane.petshop.domain.Raca;

// Este é o modelo para criação de repositories. Sempre serão dessa forma, só muda o tipo de objeto (no caso, substituímos só o "Categoria" na declaração da interface)
@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {

}
