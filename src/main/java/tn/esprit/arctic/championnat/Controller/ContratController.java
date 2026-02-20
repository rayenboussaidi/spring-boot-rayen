package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.IcontratService;

@Component
@AllArgsConstructor
public class ContratController {

    private IcontratService contratService;
}
