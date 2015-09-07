package course.api;

import course.domain.Course;
import course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hashcode on 2015/04/07.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private CourseService service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public Course getCourse(){
        Course couse = new Course.Builder("12345")
                .name("National Diploma IT").offering(2015).build();

        return couse;
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses(){
        return service.getCourses();
    }




}
