package course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/20.
 */
@Entity
public class Subject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;

    private Subject() {
    }

    public Subject(Builder builder) {
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String code;

        public Builder(String code) {
            this.code = code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }

        public Builder copy(Subject value){
            this.id=value.id;
            this.code=value.code;
            this.name=value.name;
            return this;
        }

        public Subject build(){
            return new Subject(this);
        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return id.equals(subject.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
