package tn.esprit.yassinejouini4IET.Service;

import tn.esprit.yassinejouini4IET.Domain.Employe;
import tn.esprit.yassinejouini4IET.Domain.RoleEmploye;

import java.util.List;

public interface IEmployeService {

    Employe addEmploye(Employe employe);

    Employe updateEmploye(Long id, Employe employe);

    Employe getEmployeById(Long id);

    List<Employe> getAllEmployes();

    List<Employe> getEmployesByRole(RoleEmploye role);

    List<Employe> getEmployesByAgence(Long idAgence);

    List<Employe> searchEmployesByNom(String nom);

    Employe affecterEmployeAAgence(Long idEmploye, Long idAgence);

    void deleteEmploye(Long id);
}