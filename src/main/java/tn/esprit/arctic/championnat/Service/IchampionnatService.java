package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.entity.Championnat;

import java.util.List;

public interface IchampionnatService {
    Championnat ajouterChampionnat(Championnat championnat);
    Championnat modifierChampionnat(Championnat championnat);
    void supprimerChampionnat(Long idChampionnat);
    List<Championnat> listChampionnats();
    Championnat recupererChampionnat(Long idChampionnat);
}
