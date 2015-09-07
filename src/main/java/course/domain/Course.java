package course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/04/07.
 */
@Entity
public class Course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String code;
    private int offering;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private List<Subject> subjects;

    private Course() {
    }

    public Course(Builder builder) {
        id=builder.id;
        name=builder.name;
        code=builder.code;
        offering=builder.offering;
        subjects = builder.subjects;
    }

    public Long getId() {
        return id;
    }

    public int getOffering() {
        return offering;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public static class Builder{

        private String name;
        private String code;
        private int offering;
        private Long id;
        private List<Subject> subjects;

        public Builder(String code) {
            this.code = code;
        }


        public Builder offering(int value){
            this.offering=value;
            return this;
        }

        public Builder subjects(List<Subject> value){
            this.subjects=value;
            return this;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }
        public Builder copy(Course value){
            this.name=value.getName();
            this.code=value.getCode();
            this.offering=value.getOffering();
            this.id=value.getId();
            this.subjects=value.getSubjects();
            return this;
        }



        public Course build(){
            return new Course(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        return !(id != null ? !id.equals(course.id) : course.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
