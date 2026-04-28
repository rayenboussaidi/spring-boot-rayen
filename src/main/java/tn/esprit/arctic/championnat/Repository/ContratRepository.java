package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.arctic.championnat.entity.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    @Query("SELECT c FROM Contrat c WHERE c.sponsor.idSponsor = :idSponsor AND c.annee = :annee AND c.archived = false")
    List<Contrat> findBySponsorAndAnneeActif(@Param("idSponsor") Long idSponsor, @Param("annee") String annee);
    
    @Query("SELECT c FROM Contrat c WHERE CAST(c.annee AS int) < :anneeActuelle AND c.archived = false")
    List<Contrat> findContratsExpires(@Param("anneeActuelle") Integer anneeActuelle);
    
    @Query("SELECT c FROM Contrat c WHERE CAST(c.annee AS int) = :annee AND c.archived = false ORDER BY c.equipe.libelle")
    List<Contrat> findContratsActifsParAnnee(@Param("annee") Integer annee);
}
