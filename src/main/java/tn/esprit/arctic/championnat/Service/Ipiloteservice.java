package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.DTO.PiloteDto;
import tn.esprit.arctic.championnat.entity.Pilote;

import java.util.List;

public interface Ipiloteservice {

    String addPilote(Pilote p);
    
    List<PiloteDto> listeWinners(Integer annee);
}

