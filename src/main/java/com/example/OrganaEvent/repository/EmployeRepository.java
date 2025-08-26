package com.example.OrganaEvent.repository;

import com.example.OrganaEvent.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Optional<Employe> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Employe> findByEmailAndMotDePasse(String email, String motDePasse);
}
