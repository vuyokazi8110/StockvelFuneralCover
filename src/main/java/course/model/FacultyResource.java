package course.model;

import course.domain.ContactAddress;
import course.domain.Department;
import org.springframework.hateoas.ResourceSupport;


import java.util.List;

/**
 * Created by hashcode on 2015/05/12.
 */
public class FacultyResource extends ResourceSupport{

    // Changed from id because of id in ResourceSupport
    private Long resid;
    private String name;

    private ContactAddress address;

    private List<Department> departments;

    private FacultyResource() {
    }

    public Long getResid() {
        return resid;
    }

    public String getName() {
        return name;
    }

    public ContactAddress getAddress() {
        return address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public FacultyResource(Builder builder) {
        this.address=builder.address;
        this.departments=builder.departments;
        this.resid=builder.resid;
        this.name=builder.name;
    }

    public static class Builder{
        private Long resid;
        private String name;
        private ContactAddress address;
        private List<Department> departments;

        public Builder(String name) {
            this.name = name;
        }

        public Builder resid(Long value){
            this.resid=value;
            return this;
        }


        public Builder address(ContactAddress value){
            this.address=value;
            return this;
        }

        public Builder department(List<Department> value){
            this.departments=value;
            return this;
        }

        public Builder copy(FacultyResource value){
            this.address=value.address;
            this.departments = value.departments;
            this.resid=value.resid;
            this.name=value.name;
            return this;
        }

        public FacultyResource build(){
            return new FacultyResource(this);
        }

    }





}
