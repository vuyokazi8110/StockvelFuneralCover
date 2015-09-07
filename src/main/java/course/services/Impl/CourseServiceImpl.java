package course.services.Impl;

import course.domain.Course;
import course.repository.CourseRepository;
import course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hashcode on 2015/04/13.
 */
@Service
public class CourseServiceImpl  implements CourseService{
    @Autowired
    CourseRepository repository;
    public List<Course> getCourses() {
        List<Course> allcources = new ArrayList<Course>();

        Iterable<Course> courses = repository.findAll();
        for (Course course : courses) {
            allcources.add(course);
        }
        return allcources;
    }
}
