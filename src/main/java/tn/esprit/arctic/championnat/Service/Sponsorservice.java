package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.SponsorRepository;
import tn.esprit.arctic.championnat.entity.Sponsor;

import java.time.LocalDate;
import java.util.List;

@Service
public class Sponsorservice implements Isponsorservice{
    @Autowired
    SponsorRepository sp;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        // la valeur de l'attribut dateCreation doit être automatiquement initialisé à la date système
        sponsor.setDateCreation(LocalDate.now());
        // les champs boolean archived et bloquer_contrat doivent etre initialisés à false
        sponsor.setArchived(Boolean.FALSE);
        sponsor.setBloquerContrat(Boolean.FALSE);
        return sp.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        // la valeur de l'attribut dateCreation doit être automatiquement initialisé à la date système
        // les champs boolean archived et bloquer_contrat doivent etre initialisés à false
        for (Sponsor sponsor : sponsors) {
            sponsor.setDateCreation(LocalDate.now());
            sponsor.setArchived(Boolean.FALSE);
            sponsor.setBloquerContrat(Boolean.FALSE);
        }
        return sp.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        // la dateDerniereModification doit etre initialisé à date Système
        sponsor.setDateDerniereModification(LocalDate.now());
        return sp.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
        sp.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {
        return sp.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        return sp.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        Sponsor sponsor= sp.findById(idSponsor).orElse(null);
        sponsor.setArchived(Boolean.TRUE);
        sp.save(sponsor);
        return sponsor.getArchived();

    }
}