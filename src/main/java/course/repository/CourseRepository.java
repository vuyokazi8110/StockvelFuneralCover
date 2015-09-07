package course.repository;

import course.domain.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hashcode on 2015/04/13.
 */
public interface CourseRepository extends CrudRepository<Course,Long>{
    public Course findByCode(String code);

}
