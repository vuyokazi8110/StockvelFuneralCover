package course.conf.factory;

import course.domain.Lecturer;

import java.util.Map;

/**
 * Created by hashcode on 2015/05/03.
 */
public class LecturerFactory {

    public static Lecturer createLacturer(Map<String,String> values,
                                   int age){

        Lecturer lecturer = new Lecturer
                .Builder(values.get("lastName"))
                .firstName(values.get("firstName"))
                .age(age)
                .build();
        return lecturer;
    }
}
