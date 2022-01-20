package com.cristhiane.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristhiane.petshop.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {// aqui vai funcionar tanto para a classe mãe quanto para as classes filhas! Então só precisa criar para a classe mãe

}
