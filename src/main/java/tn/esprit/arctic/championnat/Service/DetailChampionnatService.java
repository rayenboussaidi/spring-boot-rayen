package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.DetailChampionnatRepository;
import tn.esprit.arctic.championnat.entity.DetailChampionnat;

import java.util.List;

@Service
public class DetailChampionnatService implements IdetailChampionnatService {
    
    @Autowired
    DetailChampionnatRepository detailChampionnatRepository;

    @Override
    public DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detailChampionnat) {
        return detailChampionnatRepository.save(detailChampionnat);
    }

    @Override
    public DetailChampionnat modifierDetailChampionnat(DetailChampionnat detailChampionnat) {
        return detailChampionnatRepository.save(detailChampionnat);
    }

    @Override
    public void supprimerDetailChampionnat(String code) {
        detailChampionnatRepository.deleteById(code);
    }

    @Override
    public List<DetailChampionnat> listDetailChampionnats() {
        return detailChampionnatRepository.findAll();
    }

    @Override
    public DetailChampionnat recupererDetailChampionnat(String code) {
        return detailChampionnatRepository.findById(code).orElse(null);
    }
}
