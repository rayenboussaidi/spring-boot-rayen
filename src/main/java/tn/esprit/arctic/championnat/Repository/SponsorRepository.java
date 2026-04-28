package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.arctic.championnat.entity.Sponsor;

import java.util.Optional;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    @Query("SELECT s FROM Sponsor s WHERE s.nom = :nom AND s.pays = :pays")
    Optional<Sponsor> findByNomAndPays(@Param("nom") String nom, @Param("pays") String pays);
}
