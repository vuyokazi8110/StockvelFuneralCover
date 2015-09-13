/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelFullnameFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelFullnameTest {
    
    @Test
    public void testCreateFullname() throws Exception {
        
        StockvelFullname fullname = StockvelFullnameFactory
                .createFullname("Vuyo", "Wando");
        
        Assert.assertEquals("Wando",fullname.getLastName());
    }

    @Test
    public void testUpdateFullname() throws Exception {
        
        StockvelFullname fullname = StockvelFullnameFactory
                .createFullname("Vuyo", "Wando");
        
        StockvelFullname copiedFullname = new StockvelFullname.Builder("vuyo")
                .lastName("Kazi")
                .copy(fullname)
                .build();
        
        
        Assert.assertEquals("Vuyo",fullname.getFirstName());
        Assert.assertEquals("Kazi",copiedFullname.getLastName());
       
    }
}
