package com.example.OrganaEvent.services;

import com.example.OrganaEvent.entity.Evenement;
import com.example.OrganaEvent.repository.EvenementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {

    private final EvenementRepository repository;

    public EvenementService(EvenementRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Evenement createEvenement(Evenement e) {
        return repository.save(e);
    }

    // READ (all)
    public List<Evenement> getAllEvenements() {
        return repository.findAll();
    }

    // READ (by id)
    public Evenement getEvenementById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec id: " + id));
    }

    // UPDATE
    public Evenement updateEvenement(Long id, Evenement e) {
        Evenement existant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec id: " + id));

        existant.setTitle(e.getTitle());
        existant.setDate(e.getDate());
        existant.setLocation(e.getLocation());
        existant.setDescription(e.getDescription());
        existant.setSeats(e.getSeats());

        return repository.save(existant);
    }

    // DELETE
    public void deleteEvenement(Long id) {
        repository.deleteById(id);
    }
}
