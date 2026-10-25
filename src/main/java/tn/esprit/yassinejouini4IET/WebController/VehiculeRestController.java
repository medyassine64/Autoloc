package tn.esprit.yassinejouini4IET.WebController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.yassinejouini4IET.Domain.Vehicule;
import tn.esprit.yassinejouini4IET.Service.IVehiculeService;

@RestController
@RequestMapping("vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {
    private final IVehiculeService iVehiculeService;
    @PostMapping("add")
    Vehicule create(Vehicule vehicule){
        return iVehiculeService.add(vehicule);
    }
}
