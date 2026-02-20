package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.entity.Course;

import java.util.List;

public interface IcourseService {
    Course ajouterCourse(Course course);
    Course modifierCourse(Course course);
    void supprimerCourse(Long idCourse);
    List<Course> listCourses();
    Course recupererCourse(Long idCourse);
}
