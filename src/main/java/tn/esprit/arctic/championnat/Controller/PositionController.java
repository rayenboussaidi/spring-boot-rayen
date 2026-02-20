package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.IpositionService;

@Component
@AllArgsConstructor
public class PositionController {

    private IpositionService positionService;
}
