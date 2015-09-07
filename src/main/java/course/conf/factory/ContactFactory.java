package course.conf.factory;

import course.domain.ContactAddress;

/**
 * Created by hashcode on 2015/05/03.
 */
public class ContactFactory {
    public static ContactAddress createContact(String email,String code){

        ContactAddress address = new ContactAddress
                .Builder(email)
                .postalCode(code)
                .build();
        return address;
    }
}
