package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat.Service.Iequipeservice;
import tn.esprit.arctic.championnat.entity.Equipe;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {

    private Iequipeservice equipeService;

    @PostMapping("/add")
    public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }
}
