package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.PiloteRepository;
import tn.esprit.arctic.championnat.entity.Pilote;

@Service
public class Piloteservice implements Ipiloteservice{
    @Autowired
    PiloteRepository pl;

    @Override
    public String addPilote(Pilote p) {
        pl.save(p);
        return "Pilote ajouté";
    }
}

