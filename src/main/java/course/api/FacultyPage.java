package course.api;

import course.domain.Department;
import course.domain.Faculty;
import course.model.FacultyResource;
import course.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/05/10.
 */

@RestController
@RequestMapping(value="/faculty/**")
public class FacultyPage {
    @Autowired
    private FacultyService service;
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Department> getFacultyDepartments(@PathVariable Long id) {


        // ...
        return service.getDepatments(id);
    }
//
//    @RequestMapping(value="/{id}/departments", method=RequestMethod.GET)
//    List<Department> getFacultyDepartments(@PathVariable Long id) {
//        // ...
//    }
//
    @RequestMapping(value="/faculties", method=RequestMethod.GET)

    public List<FacultyResource> getFaculties() {
        List<FacultyResource> hateos = new ArrayList<>();
        List<Faculty> faculties = service.getAllFAculties();
        for (Faculty faculty : faculties) {
            FacultyResource res = new FacultyResource
                    .Builder(faculty.getName())
                    .address(faculty.getAddress())
                    .department(faculty.getDepartments())
                    .resid(faculty.getId())
                    .build();
            Link departments = new
                    Link("http://localhost:8080/faculty/"+res.getResid().toString())
                    .withRel("depts");
            res.add(departments);
            hateos.add(res);
        }
        return hateos;
    }
//

}
