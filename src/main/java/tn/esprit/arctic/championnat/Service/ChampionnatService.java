package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.ChampionnatRepository;
import tn.esprit.arctic.championnat.entity.Championnat;

import java.util.List;

@Service
public class ChampionnatService implements IchampionnatService {
    
    @Autowired
    ChampionnatRepository championnatRepository;

    @Override
    public Championnat ajouterChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }

    @Override
    public Championnat modifierChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }

    @Override
    public void supprimerChampionnat(Long idChampionnat) {
        championnatRepository.deleteById(idChampionnat);
    }

    @Override
    public List<Championnat> listChampionnats() {
        return championnatRepository.findAll();
    }

    @Override
    public Championnat recupererChampionnat(Long idChampionnat) {
        return championnatRepository.findById(idChampionnat).orElse(null);
    }
}
