package course.services;

import course.domain.Department;
import course.domain.Faculty;

import java.util.List;

/**
 * Created by hashcode on 2015/05/10.
 */
public interface FacultyService {
     List<Faculty> getAllFAculties();
     List<Department> getDepatments(Long id);
}
