package course.conf.factory;

import course.domain.ContactAddress;
import course.domain.Department;
import course.domain.Faculty;

import java.util.List;
import java.util.Map;

/**
 * Created by hashcode on 2015/05/03.
 */
public class FacultyFactory {

    public static Faculty createFaculty(ContactAddress address,
                                 List<Department> departments,
                                 String name){
        Faculty faculty = new Faculty
                .Builder(name)
                .address(address)
                .department(departments)
                .build();
        return faculty;
    }
}
