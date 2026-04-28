package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat.DTO.ContratDto;
import tn.esprit.arctic.championnat.Service.IcontratService;
import tn.esprit.arctic.championnat.entity.Contrat;

import java.util.List;

@Component
@AllArgsConstructor
@RestController
@RequestMapping("/contrat")
public class ContratController {

    private IcontratService contratService;
    
    @PostMapping("/add")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }
    
    @PutMapping("/update")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }
    
    @DeleteMapping("/delete/{id}")
    public void supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
    }
    
    @GetMapping("/all")
    public List<Contrat> listContrats() {
        return contratService.listContrats();
    }
    
    @GetMapping("/get/{id}")
    public Contrat recupererContrat(@PathVariable Long id) {
        return contratService.recupererContrat(id);
    }
    
    @PostMapping("/add-with-sponsor-equipe")
    public ContratDto ajoutContratEtAffecterASponsorEtEquipe(
            @RequestBody Contrat contrat,
            @RequestParam String libelleEquipe,
            @RequestParam String nomSponsor,
            @RequestParam String pays) {
        return contratService.ajoutContratEtAffecterASponsorEtEquipe(contrat, libelleEquipe, nomSponsor, pays);
    }
}
