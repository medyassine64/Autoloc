package tn.esprit.yassinejouini4IET.Service.Impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yassinejouini4IET.Domain.Contrat;
import tn.esprit.yassinejouini4IET.Repository.ContratRepository;
import tn.esprit.yassinejouini4IET.Service.IContratService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public Contrat addContrat(Contrat contrat) {
        if (contrat.getDateSignature() == null) {
            contrat.setDateSignature(LocalDate.now());
        }
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Long id, Contrat contrat) {
        Contrat existing = getContratById(id);
        existing.setDateSignature(contrat.getDateSignature());
        existing.setMontantTotal(contrat.getMontantTotal());
        existing.setValide(contrat.isValide());
        if (contrat.getReservation() != null) {
            existing.setReservation(contrat.getReservation());
        }
        return contratRepository.save(existing);
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable avec l'id : " + id));
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public List<Contrat> getContratsByValide(boolean valide) {
        return contratRepository.findByValide(valide);
    }

    @Override
    public List<Contrat> getContratsBetween(LocalDate debut, LocalDate fin) {
        return contratRepository.findByDateSignatureBetween(debut, fin);
    }

    @Override
    public Contrat validerContrat(Long id) {
        Contrat contrat = getContratById(id);
        contrat.setValide(true);
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new RuntimeException("Contrat introuvable avec l'id : " + id);
        }
        contratRepository.deleteById(id);
    }
}