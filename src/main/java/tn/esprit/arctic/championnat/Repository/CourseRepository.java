package tn.esprit.arctic.championnat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.arctic.championnat.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
