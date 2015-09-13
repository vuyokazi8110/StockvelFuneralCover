/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelContactFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelContactTest {
    
    
    
    @Test
    public void testCreateContact() throws Exception {
        StockvelContact contact = StockvelContactFactory
                .createContact("Vuyo@gmail.com","0215350987","0780001111");
        
        Assert.assertEquals("Vuyo@gmail.com",contact.getEmail());
    }

    @Test
    public void testUpdateContact() throws Exception {
       StockvelContact contact = StockvelContactFactory
                .createContact("Vuyo@gmail.com","0215350987","0780001111");

        StockvelContact copiedContact = new StockvelContact
                .Builder("WandoV@gmail.com")
                .HomeNumber("0210001111")
                .CellNumber("0782223333")
                .copy(contact)
                .build();
        
        Assert.assertEquals("Vuyo@gmail.com",contact.getEmail());
        Assert.assertEquals("WandoV@gmail.com",copiedContact.getEmail());
        Assert.assertEquals("0215350987",contact.getHomeNumber());
        Assert.assertEquals("0210001111",copiedContact.getHomeNumber());
        Assert.assertEquals("0780001111",contact.getCellNumber());
        Assert.assertEquals("0782223333",copiedContact.getCellNumber());
       

    }
    
   
}
