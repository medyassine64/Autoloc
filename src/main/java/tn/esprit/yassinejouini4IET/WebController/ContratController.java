package tn.esprit.yassinejouini4IET.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinejouini4IET.Domain.Contrat;
import tn.esprit.yassinejouini4IET.Service.IContratService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.addContrat(contrat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        return ResponseEntity.ok(contratService.updateContrat(id, contrat));
    }

    @PutMapping("/{id}/valider")
    public ResponseEntity<Contrat> validerContrat(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.validerContrat(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratById(id));
    }

    @GetMapping
    public ResponseEntity<List<Contrat>> getAllContrats() {
        return ResponseEntity.ok(contratService.getAllContrats());
    }

    @GetMapping("/valide/{valide}")
    public ResponseEntity<List<Contrat>> getContratsByValide(@PathVariable boolean valide) {
        return ResponseEntity.ok(contratService.getContratsByValide(valide));
    }

    @GetMapping("/periode")
    public ResponseEntity<List<Contrat>> getContratsBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate debut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(contratService.getContratsBetween(debut, fin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}