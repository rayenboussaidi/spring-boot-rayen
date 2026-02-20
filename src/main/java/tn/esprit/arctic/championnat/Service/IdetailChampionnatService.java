package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.entity.DetailChampionnat;

import java.util.List;

public interface IdetailChampionnatService {
    DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detailChampionnat);
    DetailChampionnat modifierDetailChampionnat(DetailChampionnat detailChampionnat);
    void supprimerDetailChampionnat(String code);
    List<DetailChampionnat> listDetailChampionnats();
    DetailChampionnat recupererDetailChampionnat(String code);
}
