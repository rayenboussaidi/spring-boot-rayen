package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat.DTO.PiloteDto;
import tn.esprit.arctic.championnat.Service.Ipiloteservice;
import tn.esprit.arctic.championnat.entity.Pilote;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {

    private Ipiloteservice piloteService;

    @PostMapping("/add")
    public String addPilote(@RequestBody Pilote pilote) {
        return piloteService.addPilote(pilote);
    }
    
    @GetMapping("/winners/{annee}")
    public List<PiloteDto> listeWinners(@PathVariable Integer annee) {
        return piloteService.listeWinners(annee);
    }
}
