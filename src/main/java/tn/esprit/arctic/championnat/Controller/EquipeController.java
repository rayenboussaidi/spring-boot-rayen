package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.Iequipeservice;

@Component
@AllArgsConstructor
public class EquipeController {

    private Iequipeservice equipeService;
}
