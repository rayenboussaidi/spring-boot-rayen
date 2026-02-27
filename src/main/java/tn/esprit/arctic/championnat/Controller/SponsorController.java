package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat.Service.Isponsorservice;
import tn.esprit.arctic.championnat.entity.Sponsor;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController {

    private Isponsorservice sponsorService;

    @PostMapping("/add")
    public Sponsor ajouterSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @PostMapping("/addAll")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @PutMapping("/update")
    public Sponsor modifierSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerSponsor(@PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }

    @GetMapping("/all")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    @GetMapping("/get/{id}")
    public Sponsor recupererSponsor(@PathVariable Long id) {
        return sponsorService.recupererSponsor(id);
    }

    @PutMapping("/archive/{id}")
    public Boolean archiverSponsor(@PathVariable Long id) {
        return sponsorService.archiverSponsor(id);
    }
}
