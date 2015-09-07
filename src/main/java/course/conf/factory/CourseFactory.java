package course.conf.factory;

import course.domain.Course;
import course.domain.Subject;

import java.util.List;
import java.util.Map;

/**
 * Created by hashcode on 2015/04/23.
 */
public class CourseFactory {

    public static Course createCourse(int offering,
                        Map<String,String> values,
                        List<Subject> subjects){
        Course course = new Course
                .Builder(values.get("code"))
                .name(values.get("name"))
                .offering(offering)
                .subjects(subjects)
                .build();
        return course;
    }
}
