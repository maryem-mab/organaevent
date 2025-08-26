package com.example.OrganaEvent.repository;

import com.example.OrganaEvent.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    Optional<Entreprise> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Entreprise> findByEmailAndMotDePasse(String email, String motDePasse);
}

