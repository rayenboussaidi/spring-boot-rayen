package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat.Service.Ipiloteservice;
import tn.esprit.arctic.championnat.entity.Pilote;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {

    private Ipiloteservice piloteService;

    @PostMapping("/add")
    public String addPilote(@RequestBody Pilote pilote) {
        return piloteService.addPilote(pilote);
    }
}
