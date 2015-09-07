package course.conf.factory;

import course.domain.ContactAddress;
import course.domain.Department;
import course.domain.Lecturer;

import java.util.List;

/**
 * Created by hashcode on 2015/05/03.
 */
public class DepartmentFactory {
    public static Department createDepartment(ContactAddress address,
                                              String name,
                                              List<Lecturer> lectures){
        Department dept = new Department
                .Builder(name)
                .address(address)
                .lecturers(lectures)
                .build();

        return dept;
    }
}
