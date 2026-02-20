package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.IchampionnatService;

@Component
@AllArgsConstructor
public class ChampionnatController {

    private IchampionnatService championnatService;
}
