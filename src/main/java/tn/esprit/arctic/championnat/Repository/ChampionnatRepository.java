package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.arctic.championnat.entity.Championnat;

public interface ChampionnatRepository extends JpaRepository<Championnat, Long> {
}
