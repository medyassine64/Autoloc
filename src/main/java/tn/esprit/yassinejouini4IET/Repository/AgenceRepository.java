package tn.esprit.yassinejouini4IET.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.yassinejouini4IET.Domain.Agence;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

    List<Agence> findByVille(String ville);

    List<Agence> findByNomContainingIgnoreCase(String nom);
}