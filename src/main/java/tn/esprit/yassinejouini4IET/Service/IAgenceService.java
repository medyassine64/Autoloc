package tn.esprit.yassinejouini4IET.Service;

import tn.esprit.yassinejouini4IET.Domain.Agence;

import java.util.List;

public interface IAgenceService {

    Agence addAgence(Agence agence);

    Agence updateAgence(Long id, Agence agence);

    Agence getAgenceById(Long id);

    List<Agence> getAllAgences();

    List<Agence> getAgencesByVille(String ville);

    void deleteAgence(Long id);
}