package tn.esprit.yassinejouini4IET.Service.Impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yassinejouini4IET.Domain.Agence;
import tn.esprit.yassinejouini4IET.Domain.Employe;
import tn.esprit.yassinejouini4IET.Domain.RoleEmploye;
import tn.esprit.yassinejouini4IET.Repository.AgenceRepository;
import tn.esprit.yassinejouini4IET.Repository.EmployeRepository;
import tn.esprit.yassinejouini4IET.Service.IEmployeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {
        Employe existing = getEmployeById(id);
        existing.setNom(employe.getNom());
        existing.setPrenom(employe.getPrenom());
        existing.setRole(employe.getRole());
        if (employe.getAgence() != null) {
            existing.setAgence(employe.getAgence());
        }
        return employeRepository.save(existing);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employé introuvable avec l'id : " + id));
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public List<Employe> getEmployesByRole(RoleEmploye role) {
        return employeRepository.findByRole(role);
    }

    @Override
    public List<Employe> getEmployesByAgence(Long idAgence) {
        return employeRepository.findByAgence_IdAgence(idAgence);
    }

    @Override
    public List<Employe> searchEmployesByNom(String nom) {
        return employeRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public Employe affecterEmployeAAgence(Long idEmploye, Long idAgence) {
        Employe employe = getEmployeById(idEmploye);
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable avec l'id : " + idAgence));
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new RuntimeException("Employé introuvable avec l'id : " + id);
        }
        employeRepository.deleteById(id);
    }
}