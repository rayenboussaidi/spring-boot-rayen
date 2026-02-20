package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.Ipiloteservice;

@Component
@AllArgsConstructor
public class PiloteController {

    private Ipiloteservice piloteService;
}
