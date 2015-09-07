package course.domain;

import course.conf.factory.SubjectFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hashcode on 2015/05/03.
 */
public class SubjectTest {
    @Test
    public void testCreate() throws Exception {
        Subject subject = SubjectFactory
                .createSubject("TPG300S","Technical Programming 3");
        Assert.assertEquals("TPG300S",subject.getCode());
    }

    @Test
    public void testUpdate() throws Exception {
        Subject subject = new Subject.Builder("TPG300S")
                .name("Technical Programing 3")
                .id(new Long(3))
                .build();
        Subject newsubject = new Subject
                .Builder(subject.getCode())
                .copy(subject)
                .name("Technical").build();

        Assert.assertEquals("Technical",newsubject.getName());
        Assert.assertEquals("TPG300S",newsubject.getCode());
        Assert.assertEquals("TPG300S",subject.getCode());


    }
}
