package com.example.OrganaEvent.services;
import com.example.OrganaEvent.entity.Employe;
import com.example.OrganaEvent.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    // Ajouter un employé
    public Employe register(Employe employe) {
        if (employeRepository.existsByEmail(employe.getEmail())) {
            throw new RuntimeException("Email déjà utilisé !");
        }
        return employeRepository.save(employe);
    }

    // Récupérer tous les employés
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    // Récupérer un employé par ID
    public Employe getById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }
}
