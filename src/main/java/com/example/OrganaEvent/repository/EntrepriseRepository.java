package com.example.OrganaEvent.repository;

import com.example.OrganaEvent.entity.entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<entreprise, Long> {
    boolean existsByEmailAndMotDePasse(String email, String motDePasse);

}
