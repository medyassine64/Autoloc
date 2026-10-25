package tn.esprit.yassinejouini4IET.Service.Impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yassinejouini4IET.Domain.Agence;
import tn.esprit.yassinejouini4IET.Service.IAgenceService;
import tn.esprit.yassinejouini4IET.Repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Long id, Agence agence) {
        Agence existing = agenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence introuvable avec l'id : " + id));
        existing.setNom(agence.getNom());
        existing.setVille(agence.getVille());
        existing.setAdresse(agence.getAdresse());
        existing.setTelephone(agence.getTelephone());
        return agenceRepository.save(existing);
    }

    @Override
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence introuvable avec l'id : " + id));
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public List<Agence> getAgencesByVille(String ville) {
        return agenceRepository.findByVille(ville);
    }

    @Override
    public void deleteAgence(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new RuntimeException("Agence introuvable avec l'id : " + id);
        }
        agenceRepository.deleteById(id);
    }
}