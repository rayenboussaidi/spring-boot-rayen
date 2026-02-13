package tn.esprit.arctic.championnat.Service;

import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.PiloteRepository;
import tn.esprit.arctic.championnat.entity.Pilote;

@Service
public class Piloteservice implements Ipiloteservice{
    PiloteRepository pl;

    @Override
    public Pilote ajouterpilote(Pilote pilote) {
       return  pl.save(pilote);
    }
}

