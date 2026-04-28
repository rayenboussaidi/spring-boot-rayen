package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.DTO.PiloteDto;
import tn.esprit.arctic.championnat.Repository.ChampionnatRepository;
import tn.esprit.arctic.championnat.Repository.PiloteRepository;
import tn.esprit.arctic.championnat.entity.Championnat;
import tn.esprit.arctic.championnat.entity.Course;
import tn.esprit.arctic.championnat.entity.Pilote;
import tn.esprit.arctic.championnat.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class Piloteservice implements Ipiloteservice{
    @Autowired
    PiloteRepository pl;
    
    @Autowired
    ChampionnatRepository championnatRepository;

    @Override
    public String addPilote(Pilote p) {
        pl.save(p);
        return "Pilote ajouté";
    }
    
    @Override
    public List<PiloteDto> listeWinners(Integer annee) {
        List<PiloteDto> winners = new ArrayList<>();
        
        // Get all championships with year > annee
        List<Championnat> championnats = championnatRepository.findChampionnatsByAnneeGreaterThan(annee);
        
        for (Championnat championnat : championnats) {
            // For each championship, find the pilot with classement = 1 (winner)
            for (Course course : championnat.getCourses()) {
                for (Position position : course.getPositions()) {
                    if (position.getClassement() != null && position.getClassement() == 1) {
                        Pilote pilote = position.getPilote();
                        PiloteDto dto = new PiloteDto();
                        dto.setIdPilote(pilote.getIdPilote());
                        dto.setLibelleP(pilote.getLibelleP());
                        dto.setNbPointsTotal(pilote.getNbPointsTotal());
                        dto.setClassementGeneral(pilote.getClassementGeneral());
                        if (pilote.getCategorie() != null) {
                            dto.setCategorie(pilote.getCategorie().toString());
                        }
                        if (pilote.getEquipe() != null) {
                            dto.setEquipeLibelle(pilote.getEquipe().getLibelle());
                        }
                        winners.add(dto);
                    }
                }
            }
        }
        
        return winners;
    }
}

