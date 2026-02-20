package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.EquipeRepository;
import tn.esprit.arctic.championnat.entity.Equipe;

@Service
public class Equipeservice implements Iequipeservice {

    @Autowired
    EquipeRepository eq;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return eq.save(equipe);
    }
}

