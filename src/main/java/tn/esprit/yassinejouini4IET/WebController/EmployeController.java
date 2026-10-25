package tn.esprit.yassinejouini4IET.WebController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinejouini4IET.Domain.Employe;
import tn.esprit.yassinejouini4IET.Domain.RoleEmploye;
import tn.esprit.yassinejouini4IET.Service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> addEmploye(@RequestBody Employe employe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.addEmploye(employe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        return ResponseEntity.ok(employeService.updateEmploye(id, employe));
    }

    @PutMapping("/{idEmploye}/agence/{idAgence}")
    public ResponseEntity<Employe> affecterEmployeAAgence(@PathVariable Long idEmploye,
                                                          @PathVariable Long idAgence) {
        return ResponseEntity.ok(employeService.affecterEmployeAAgence(idEmploye, idAgence));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeService.getEmployeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        return ResponseEntity.ok(employeService.getAllEmployes());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Employe>> getEmployesByRole(@PathVariable RoleEmploye role) {
        return ResponseEntity.ok(employeService.getEmployesByRole(role));
    }

    @GetMapping("/agence/{idAgence}")
    public ResponseEntity<List<Employe>> getEmployesByAgence(@PathVariable Long idAgence) {
        return ResponseEntity.ok(employeService.getEmployesByAgence(idAgence));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employe>> searchEmployesByNom(@RequestParam String nom) {
        return ResponseEntity.ok(employeService.searchEmployesByNom(nom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}