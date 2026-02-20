package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.arctic.championnat.entity.DetailChampionnat;

public interface DetailChampionnatRepository extends JpaRepository<DetailChampionnat, String> {
}
