package com.example.OrganaEvent.repository;

import com.example.OrganaEvent.entity.organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisateurRepository extends JpaRepository<organisateur, Long> {
    boolean existsByEmailAndMotDePasse(String email, String motDePasse);

}
