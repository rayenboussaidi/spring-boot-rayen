package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.arctic.championnat.entity.Equipe;

import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Query("SELECT e FROM Equipe e WHERE e.libelle = :libelle")
    Optional<Equipe> findByLibelle(@Param("libelle") String libelle);
}

