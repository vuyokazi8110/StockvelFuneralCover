package course.services.Impl;

import course.domain.Department;
import course.domain.Faculty;
import course.repository.FacultyRepository;
import course.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/05/10.
 */
@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository repository;
    @Override
    public List<Faculty> getAllFAculties() {
        List<Faculty> faculties = new ArrayList<>();
        Iterable<Faculty> values = repository.findAll();
        for (Faculty value : values) {
            faculties.add(value);
        }
        return faculties;
    }

    @Override
    public List<Department> getDepatments(Long id) {

        return repository.findOne(id).getDepartments();
    }



}
