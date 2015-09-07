package course.domain;

import course.conf.factory.ContactFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hashcode on 2015/05/03.
 */
public class ContactAddressTest {
    @Test
    public void testCreate() throws Exception {
        ContactAddress address = ContactFactory
                .createContact("test@test.com","7557");
        Assert.assertEquals("test@test.com",address.getEmail());
    }

    @Test
    public void testUpdate() throws Exception {
        ContactAddress address = ContactFactory
                .createContact("test@test.com","7557");

        ContactAddress copiedaddress = new ContactAddress
                .Builder("test@test.comm").copy(address).postalCode("700").build();
        Assert.assertEquals("test@test.com",address.getEmail());
        Assert.assertEquals("test@test.com",copiedaddress.getEmail());
        Assert.assertEquals("7557",address.getPostalCode());
        Assert.assertEquals("700",copiedaddress.getPostalCode());

    }
}
