package com.example.OrganaEvent.controller;

import com.example.OrganaEvent.entity.Organisateur;
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
    public Organisateur ajouterOrganisateur(@RequestBody Organisateur organisateur) {
        return organisateurRepository.save(organisateur);
    }

    @GetMapping("/all")
    public List<Organisateur> getAllOrganisateurs() {
        return organisateurRepository.findAll();
    }
}
