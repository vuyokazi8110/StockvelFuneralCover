package course.repository;

import course.domain.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hashcode on 2015/05/03.
 */
public interface DepartmentRespository extends CrudRepository<Department,Long> {
}
