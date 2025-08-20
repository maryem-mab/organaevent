// 📁 fichier : EmployeRepository.java
package com.example.OrganaEvent.repository;

import com.example.OrganaEvent.entity.employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<employe, Long> {
    // Tu peux ajouter ici des méthodes personnalisées si besoin
    boolean existsByEmailAndMotDePasse(String email, String motDePasse);

}
