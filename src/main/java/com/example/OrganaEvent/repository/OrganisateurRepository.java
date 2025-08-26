package com.example.OrganaEvent.repository;

import com.example.OrganaEvent.entity.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisateurRepository extends JpaRepository<Organisateur, Long> {
    Organisateur findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<Organisateur> findByEmailAndMotDePasse(String email, String motDePasse);

    boolean existsByEmailAndMotDePasse(String email, String motDePasse);
}


