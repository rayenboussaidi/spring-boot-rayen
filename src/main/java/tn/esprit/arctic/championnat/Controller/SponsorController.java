package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.Isponsorservice;

@Component
@AllArgsConstructor
public class SponsorController {

    private Isponsorservice sponsorService;
}
