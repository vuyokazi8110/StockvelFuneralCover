package course.domain;

import course.conf.factory.StockvelAddressFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelAddressTest {
    
    @Test
    public void testCreateAddress() throws Exception {
        StockvelAddress address = StockvelAddressFactory
                .createAddress("13","Johnson Street","Park View","8001");
        
        Assert.assertEquals("8001",address.getPostalCode());
    }

    @Test
    public void testUpdateAdress() throws Exception {
        StockvelAddress address = StockvelAddressFactory
                .createAddress("13","Johnson Street","Park View","8001");

        StockvelAddress copiedaddress = new StockvelAddress
                .Builder()
                .streetNo("15")
                .streetName("Park Street")
                .suburb("Park View")
                .postalCode("7721")
                .copy(address)
                .build();
        
        Assert.assertEquals("13",address.getStreetNo());
        Assert.assertEquals("15",copiedaddress.getStreetNo());
        Assert.assertEquals("Johnson Street",address.getStreetName());
        Assert.assertEquals("Park Street",copiedaddress.getStreetName());
        Assert.assertEquals("Park View",address.getSuburb());
        Assert.assertEquals("Park View",copiedaddress.getSuburb());
        Assert.assertEquals("8001",address.getPostalCode());
        Assert.assertEquals("7721",copiedaddress.getPostalCode());

    }
}
