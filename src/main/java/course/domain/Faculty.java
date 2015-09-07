package course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/04/20.
 */
@Entity
public class Faculty implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private ContactAddress address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="faculty_id")
    private List<Department> departments;

    private Faculty() {
    }

    public Long getId() {
        return id;
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

    public Faculty(Builder builder) {
        this.address=builder.address;
        this.departments=builder.departments;
        this.id=builder.id;
        this.name=builder.name;
    }

    public static class Builder{
        private Long id;
        private String name;
        private ContactAddress address;
        private List<Department> departments;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            this.id=value;
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

        public Builder copy(Faculty value){
            this.address=value.address;
            this.departments = value.departments;
            this.id=value.id;
            this.name=value.name;
            return this;
        }

        public Faculty build(){
            return new Faculty(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        return id.equals(faculty.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}
