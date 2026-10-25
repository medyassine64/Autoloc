package tn.esprit.yassinejouini4IET.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.yassinejouini4IET.Domain.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    Optional<Client> findByNumPermis(String numPermis);

    List<Client> findByNomContainingIgnoreCase(String nom);

    boolean existsByEmail(String email);
}