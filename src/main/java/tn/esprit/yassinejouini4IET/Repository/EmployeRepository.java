package tn.esprit.yassinejouini4IET.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.yassinejouini4IET.Domain.Employe;
import tn.esprit.yassinejouini4IET.Domain.RoleEmploye;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findByRole(RoleEmploye role);

    List<Employe> findByAgence_IdAgence(Long idAgence);

    List<Employe> findByNomContainingIgnoreCase(String nom);
}