package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.entity.Sponsor;

import java.util.List;

public interface Isponsorservice {
    Sponsor ajouterSponsor(Sponsor sponsor);

    List<Sponsor> ajouterSponsors(List<Sponsor> sponsors);

    Sponsor modifierSponsor(Sponsor sponsor);

    void supprimerSponsor (Long idSponsor);

    List<Sponsor> listSponsors();

    Sponsor recupererSponsor(Long idSponsor);

    Boolean archiverSponsor(Long idSponsor);
}
