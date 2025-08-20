package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.entity.organisateur;
import com.example.OrganaEvent.repository.OrganisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisateurs")
public class OrganisateurController {

    @Autowired
    private OrganisateurRepository organisateurRepository;

    @PostMapping("/add")
    public organisateur ajouterOrganisateur(@RequestBody organisateur organisateur) {
        return organisateurRepository.save(organisateur);
    }

    @GetMapping("/all")
    public List<organisateur> getAllOrganisateurs() {
        return organisateurRepository.findAll();
    }
}
