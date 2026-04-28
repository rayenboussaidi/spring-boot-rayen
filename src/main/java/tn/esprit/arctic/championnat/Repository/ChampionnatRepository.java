package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.arctic.championnat.entity.Championnat;

import java.util.List;

public interface ChampionnatRepository extends JpaRepository<Championnat, Long> {
    @Query("SELECT c FROM Championnat c WHERE c.annee > :annee")
    List<Championnat> findChampionnatsByAnneeGreaterThan(@Param("annee") Integer annee);
}
