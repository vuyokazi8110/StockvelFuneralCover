package course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/20.
 */
@Embeddable
public class ContactAddress implements Serializable{
    private String email;
    private String postalCode;

    private ContactAddress() {
    }

    public ContactAddress(Builder builder) {
        email=builder.email;
        postalCode=builder.postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder{
        private String email;
        private String postalCode;

        public Builder(String email) {
            this.email = email;
        }

        public Builder postalCode(String value){
            this.postalCode=value;
            return this;
        }

        public Builder copy(ContactAddress value){
            this.postalCode=value.postalCode;
            this.email=value.email;
            return this;
        }

        public ContactAddress build(){
            return new ContactAddress(this);
        }
    }

}
