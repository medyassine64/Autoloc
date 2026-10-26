package tn.esprit.yassinejouini4IET.WebController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yassinejouini4IET.Domain.Vehicule;
import tn.esprit.yassinejouini4IET.Service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeService iVehiculeService;

    // POST /vehicules/add
    @PostMapping("add")
    public ResponseEntity<Vehicule> create(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iVehiculeService.add(vehicule));
    }

    // GET /vehicules/getAll
    @GetMapping("getAll")
    public List<Vehicule> getAll() {
        return iVehiculeService.findAll();
    }

    // GET /vehicules/get/{id}
    @GetMapping("get/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return iVehiculeService.findById(id);
    }

    // PUT /vehicules/update
    @PutMapping("update")
    public Vehicule update(@RequestBody Vehicule vehicule) {
        return iVehiculeService.update(vehicule);
    }

    // DELETE /vehicules/delete/{id}
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        iVehiculeService.delete(id);
    }
}