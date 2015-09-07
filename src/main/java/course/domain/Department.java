package course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/04/20.
 */
@Entity
public class Department  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private ContactAddress address;
    @OneToMany
    @JoinColumn(name = "dept_id")
    private List<Lecturer> lecturers;

    private Department() {
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

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public Department(Builder builder) {
        this.address=builder.address;
        this.id=builder.id;
        this.lecturers=builder.lecturers;
        this.name=builder.name;
    }

    public static class Builder{
        private Long id;
        private String name;
        private ContactAddress address;
        private List<Lecturer> lecturers;

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

        public Builder lecturers(List<Lecturer> value){
            this.lecturers=value;
            return this;
        }

        public Builder copy(Department value){
            this.lecturers=value.lecturers;
            this.address=value.address;
            this.id=value.id;
            this.name=value.name;
            return this;
        }

        public Department build(){
            return new Department(this);
        }

    }
}
