package tn.esprit.yassinejouini4IET.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.yassinejouini4IET.Domain.Contrat;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findByValide(boolean valide);

    List<Contrat> findByDateSignatureBetween(LocalDate debut, LocalDate fin);
}