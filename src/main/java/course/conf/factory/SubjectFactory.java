package course.conf.factory;

import course.domain.Subject;

/**
 * Created by hashcode on 2015/05/03.
 */
public class SubjectFactory {
    public static Subject createSubject(String code,String name){
        Subject subject = new Subject
                .Builder(code)
                .name(name)
                .build();
        return subject;
    }
}
