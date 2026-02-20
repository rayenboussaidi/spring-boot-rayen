package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.CourseRepository;
import tn.esprit.arctic.championnat.entity.Course;

import java.util.List;

@Service
public class CourseService implements IcourseService {
    
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course ajouterCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course modifierCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void supprimerCourse(Long idCourse) {
        courseRepository.deleteById(idCourse);
    }

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course recupererCourse(Long idCourse) {
        return courseRepository.findById(idCourse).orElse(null);
    }
}
