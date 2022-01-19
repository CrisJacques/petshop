package com.cristhiane.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristhiane.petshop.domain.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

}
