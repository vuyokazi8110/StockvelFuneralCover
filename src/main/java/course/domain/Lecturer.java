package course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/07.
 */
@Entity
public class Lecturer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    private Lecturer() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Lecturer(Builder builder){
        id = builder.id;
        firstName=builder.firstName;
        lastName=builder.lastName;
        age=builder.age;
    }

    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private int age;

        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder copy(Lecturer value){
            this.age=value.age;
            this.id=value.id;
            this.firstName=value.firstName;
            this.lastName=value.lastName;
            return this;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder age(int value){
            this.age=value;
            return this;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Lecturer build(){
            return new Lecturer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        return id.equals(lecturer.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
