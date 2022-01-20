package com.cristhiane.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristhiane.petshop.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
