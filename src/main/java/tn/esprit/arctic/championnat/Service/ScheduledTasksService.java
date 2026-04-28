package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.DTO.ContratActifParEquipeDto;
import tn.esprit.arctic.championnat.DTO.ContratSimpleDto;
import tn.esprit.arctic.championnat.DTO.SponsorBudgetDto;
import tn.esprit.arctic.championnat.Repository.ContratRepository;
import tn.esprit.arctic.championnat.Repository.EquipeRepository;
import tn.esprit.arctic.championnat.Repository.PiloteRepository;
import tn.esprit.arctic.championnat.Repository.SponsorRepository;
import tn.esprit.arctic.championnat.entity.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ScheduledTasksService {
    
    @Autowired
    private ContratRepository contratRepository;
    
    @Autowired
    private SponsorRepository sponsorRepository;
    
    @Autowired
    private EquipeRepository equipeRepository;
    
    @Autowired
    private PiloteRepository piloteRepository;
    
    @Autowired
    private Isponsorservice sponsorService;

    /**
     * 5.1 - Execute every 30 seconds
     * Archives expired contracts and displays active contracts by team
     */
    @Scheduled(fixedDelay = 30000) // 30 seconds
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {
        System.out.println("========== SCHEDULED TASK 5.1: Archive Expired Contracts & Display Active by Team ==========");
        System.out.println("Execution time: " + LocalDate.now());
        
        int anneeActuelle = LocalDate.now().getYear();
        
        // Archive expired contracts (year < current year)
        List<Contrat> contratsExpires = contratRepository.findContratsExpires(anneeActuelle);
        for (Contrat contrat : contratsExpires) {
            contrat.setArchived(true);
            contratRepository.save(contrat);
            System.out.println("✓ Archived contract ID: " + contrat.getIdContrat() + " (Year: " + contrat.getAnnee() + ")");
        }
        
        if (contratsExpires.isEmpty()) {
            System.out.println("ℹ No expired contracts to archive.");
        }
        
        System.out.println("\n--- Active Contracts by Team (Current Year: " + anneeActuelle + ") ---");
        
        // Get active contracts for current year, grouped by team
        List<Contrat> contratsActifs = contratRepository.findContratsActifsParAnnee(anneeActuelle);
        
        Map<String, List<Contrat>> contratsParEquipe = new HashMap<>();
        for (Contrat contrat : contratsActifs) {
            String equipeLibelle = contrat.getEquipe().getLibelle();
            contratsParEquipe.computeIfAbsent(equipeLibelle, k -> new ArrayList<>()).add(contrat);
        }
        
        // Display active contracts by team
        if (contratsParEquipe.isEmpty()) {
            System.out.println("ℹ No active contracts for the current year.");
        } else {
            for (Map.Entry<String, List<Contrat>> entry : contratsParEquipe.entrySet()) {
                System.out.println("\n📋 Team: " + entry.getKey());
                System.out.println("   Number of contracts: " + entry.getValue().size());
                for (Contrat contrat : entry.getValue()) {
                    System.out.println("   - Contract ID: " + contrat.getIdContrat() + 
                            ", Sponsor: " + contrat.getSponsor().getNom() + 
                            ", Amount: $" + contrat.getMontant());
                }
            }
        }
        
        System.out.println("========== END OF TASK 5.1 ==========\n");
    }

    /**
     * 5.2 - Execute every Monday at 9:00 AM
     * Display budget consumption percentage for each sponsor
     */
    @Scheduled(cron = "0 0 9 ? * MON") // Monday at 9:00 AM
    public void affichagePourcentageBudgetConsommeParSponsor() {
        System.out.println("========== SCHEDULED TASK 5.2: Display Sponsor Budget Consumption ==========");
        System.out.println("Execution time: " + LocalDate.now());
        System.out.println("Current Year: " + LocalDate.now().getYear());
        
        List<Sponsor> sponsors = sponsorRepository.findAll();
        
        if (sponsors.isEmpty()) {
            System.out.println("ℹ No sponsors found.");
            return;
        }
        
        System.out.println("\n--- Budget Consumption Report ---\n");
        
        for (Sponsor sponsor : sponsors) {
            Double pourcentage = sponsorService.pourcentageBudgetAnnuelConsomme(sponsor.getIdSponsor());
            
            System.out.println("Sponsor: " + sponsor.getNom() + " (" + sponsor.getPays() + ")");
            System.out.println("Budget Annual: $" + sponsor.getBudgetAnnuel());
            System.out.println("Percentage Consumed: " + String.format("%.2f", pourcentage) + "%");
            
            String message = "";
            if (pourcentage > 70 && pourcentage < 100) {
                message = "⚠️  Attention budget presque consommé : " + String.format("%.0f", pourcentage) + " % !";
                System.out.println(message);
            } else if (pourcentage >= 100) {
                message = "🛑 Budget dépassé!! vous ne pouvez plus faire de contrats";
                System.out.println(message);
                
                // Set bloquerContrat to true
                sponsor.setBloquerContrat(true);
                sponsorRepository.save(sponsor);
                System.out.println("   ✓ Field 'bloquerContrat' set to TRUE");
            } else {
                System.out.println("✓ Budget consumption is normal");
            }
            
            System.out.println("---");
        }
        
        System.out.println("========== END OF TASK 5.2 ==========\n");
    }

    /**
     * 5.3 - Execute every December 31st at 11:15 AM
     * Update pilot points and general ranking for the current year
     */
    @Scheduled(cron = "0 15 11 31 12 ?") // December 31st at 11:15 AM
    public void mettreAJourPointsPilotesEtClassement() {
        System.out.println("========== SCHEDULED TASK 5.3: Update Pilot Points and Rankings ==========");
        System.out.println("Execution time: " + LocalDate.now());
        System.out.println("Current Year: " + LocalDate.now().getYear());
        
        int anneeActuelle = LocalDate.now().getYear();
        
        // Get all pilots
        List<Pilote> pilotes = piloteRepository.findAll();
        
        if (pilotes.isEmpty()) {
            System.out.println("ℹ No pilots found.");
            return;
        }
        
        System.out.println("\n--- Updating Pilot Points and Rankings ---\n");
        
        Map<Pilote, Integer> pilotePointsMap = new HashMap<>();
        
        // Calculate total points for each pilot based on positions
        for (Pilote pilote : pilotes) {
            Integer totalPoints = 0;
            
            for (Position position : pilote.getPositions()) {
                if (position.getNbPoints() != null) {
                    totalPoints += position.getNbPoints();
                }
            }
            
            pilotePointsMap.put(pilote, totalPoints);
            pilote.setNbPointsTotal(totalPoints);
        }
        
        // Sort pilots by total points (descending)
        List<Pilote> pilotsRanked = pilotePointsMap.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        
        // Update ranking for each pilot
        int rank = 1;
        for (Pilote pilote : pilotsRanked) {
            pilote.setClassementGeneral(rank);
            piloteRepository.save(pilote);
            
            System.out.println("Rank " + rank + ": " + pilote.getLibelleP() + 
                    " - Points: " + pilote.getNbPointsTotal());
            rank++;
        }
        
        System.out.println("\n✓ All pilots updated successfully!");
        System.out.println("========== END OF TASK 5.3 ==========\n");
    }
}

