package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.DTO.ContratDto;
import tn.esprit.arctic.championnat.Repository.ContratRepository;
import tn.esprit.arctic.championnat.Repository.EquipeRepository;
import tn.esprit.arctic.championnat.Repository.SponsorRepository;
import tn.esprit.arctic.championnat.entity.Contrat;
import tn.esprit.arctic.championnat.entity.Equipe;
import tn.esprit.arctic.championnat.entity.Sponsor;

import java.util.List;

@Service
public class ContratService implements IcontratService {
    
    @Autowired
    ContratRepository contratRepository;
    
    @Autowired
    EquipeRepository equipeRepository;
    
    @Autowired
    SponsorRepository sponsorRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimerContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public List<Contrat> listContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat recupererContrat(Long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }
    
    @Override
    public ContratDto ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, String libelleEquipe, String nomSponsor, String pays) {
        // Find or create Equipe
        Equipe equipe = equipeRepository.findByLibelle(libelleEquipe)
                .orElseThrow(() -> new RuntimeException("Equipe not found with libelle: " + libelleEquipe));
        
        // Find or create Sponsor
        Sponsor sponsor = sponsorRepository.findByNomAndPays(nomSponsor, pays)
                .orElseThrow(() -> new RuntimeException("Sponsor not found with nom: " + nomSponsor + " and pays: " + pays));
        
        // Assign sponsor and equipe to contract
        contrat.setEquipe(equipe);
        contrat.setSponsor(sponsor);
        
        // Save the contract
        Contrat savedContrat = contratRepository.save(contrat);
        
        // Convert to DTO (manual mapping)
        ContratDto dto = new ContratDto();
        dto.setIdContrat(savedContrat.getIdContrat());
        dto.setMontant(savedContrat.getMontant());
        dto.setAnnee(savedContrat.getAnnee());
        dto.setArchived(savedContrat.getArchived());
        dto.setEquipeLibelle(savedContrat.getEquipe().getLibelle());
        dto.setSponsorNom(savedContrat.getSponsor().getNom());
        dto.setSponsorPays(savedContrat.getSponsor().getPays());
        
        return dto;
    }
}
