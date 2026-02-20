package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.IdetailChampionnatService;

@Component
@AllArgsConstructor
public class DetailChampionnatController {

    private IdetailChampionnatService detailChampionnatService;
}
