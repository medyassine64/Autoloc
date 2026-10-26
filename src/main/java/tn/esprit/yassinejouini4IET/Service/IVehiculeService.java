package tn.esprit.yassinejouini4IET.Service;

import tn.esprit.yassinejouini4IET.Domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule getById(long id);
    Vehicule add(Vehicule vehicule);
    Vehicule update(Vehicule vehicule);
    void deleteById(long id);
    List<Vehicule> findAll();

    Vehicule findById(Long id);

    void delete(Long id);
}
