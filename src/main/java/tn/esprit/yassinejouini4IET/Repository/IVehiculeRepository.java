package tn.esprit.yassinejouini4IET.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.yassinejouini4IET.Domain.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule,Long> {
}
