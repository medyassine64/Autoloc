package tn.esprit.yassinejouini4IET.Service;

import tn.esprit.yassinejouini4IET.Domain.Contrat;

import java.time.LocalDate;
import java.util.List;

public interface IContratService {

    Contrat addContrat(Contrat contrat);

    Contrat updateContrat(Long id, Contrat contrat);

    Contrat getContratById(Long id);

    List<Contrat> getAllContrats();

    List<Contrat> getContratsByValide(boolean valide);

    List<Contrat> getContratsBetween(LocalDate debut, LocalDate fin);

    Contrat validerContrat(Long id);

    void deleteContrat(Long id);
}