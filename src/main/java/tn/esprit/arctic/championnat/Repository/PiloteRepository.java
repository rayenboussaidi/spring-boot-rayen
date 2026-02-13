package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.arctic.championnat.entity.Pilote;

public interface PiloteRepository extends JpaRepository<Pilote, Long> {
}

