package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.entity.Contrat;

import java.util.List;

public interface IcontratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat(Contrat contrat);
    void supprimerContrat(Long idContrat);
    List<Contrat> listContrats();
    Contrat recupererContrat(Long idContrat);
}
