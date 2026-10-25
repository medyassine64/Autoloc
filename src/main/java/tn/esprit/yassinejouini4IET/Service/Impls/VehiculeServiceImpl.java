package tn.esprit.yassinejouini4IET.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yassinejouini4IET.Domain.Vehicule;
import tn.esprit.yassinejouini4IET.Repository.IVehiculeRepository;
import tn.esprit.yassinejouini4IET.Service.IVehiculeService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository IvehiculeRepository;

   @Override
    public Vehicule getById(long id) {
        return IvehiculeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("vehicule not found")) ;
    }

    @Override
    public Vehicule add(Vehicule vehicule) {
        return IvehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return IvehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteById(long id) {
        IvehiculeRepository.deleteById(id);
    }



    @Override
    public List<Vehicule> findAll() {
        return List.of();
    }
}
