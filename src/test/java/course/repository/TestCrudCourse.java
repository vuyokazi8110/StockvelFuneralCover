package course.repository;

import course.App;
import course.domain.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/04/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudCourse {


    @Autowired
    CourseRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Course> courses = new ArrayList<Course>();
        Course course = new Course.Builder("1111")
                .name("National Diploma IT").offering(2015).build();
        repository.save(course);
        Assert.assertNotNull(course.getId());

        course = repository.findOne(course.getId());
        Assert.assertEquals("National Diploma IT", course.getName());


        Course newcourse = new Course.Builder("81111").id(course.getId())
                .name("National Diploma IT").offering(2014).build();
        repository.save(newcourse);
        Assert.assertEquals("National Diploma IT", course.getName());
        Assert.assertEquals(2015, course.getOffering());

       course = repository.findOne(course.getId());
        repository.delete(course);
        newcourse = repository.findOne(course.getId());
        Assert.assertNull(newcourse);
    }


}
