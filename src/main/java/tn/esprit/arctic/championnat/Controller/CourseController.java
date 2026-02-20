package tn.esprit.arctic.championnat.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.arctic.championnat.Service.IcourseService;

@Component
@AllArgsConstructor
public class CourseController {

    private IcourseService courseService;
}
