/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelSubmemberFactory;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelSubmemberTest {
    
    @Test
    public void testCreateSubMember() throws Exception {
        
        StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Vuyo")
                .build();
        
        StockvelDemographic stockvelDemographic = new StockvelDemographic
                .Builder("8505260089081")
                .build();
        
        StockvelAddress stockvelAddress = new StockvelAddress
                .Builder()
                .streetName("Sheet Street")
                .build();
        
        StockvelContact stockvelContact = new StockvelContact.
                Builder("VuyoW@gmail.com")
                .build();
             
        StockvelSubmember submember = StockvelSubmemberFactory
                .createSubmember(stokvelFullname, 
                        stockvelDemographic, 
                        stockvelAddress, 
                        stockvelContact,true);
        
        Assert.assertTrue(submember.isBeneficiary());
    }

    @Test
    public void testUpdateSubMember() throws Exception {
        
        
         StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Vuyo")
                .build();
        
        StockvelDemographic stockvelDemographic = new StockvelDemographic
                .Builder("8505260089081")
                .build();
        
        StockvelAddress stockvelAddress = new StockvelAddress
                .Builder()
                .streetName("Sheet Street")
                .build();
        
        StockvelContact stockvelContact = new StockvelContact.
                Builder("VuyoW@gmail.com")
                .build();
             
        StockvelSubmember submember = StockvelSubmemberFactory
                .createSubmember(stokvelFullname, 
                        stockvelDemographic, 
                        stockvelAddress, 
                        stockvelContact,true);
        
        

        StockvelSubmember copiedsubmember = new StockvelSubmember
                .Builder()
                .stokvelFullname(stokvelFullname)
                .stockvelDemographic(stockvelDemographic)
                .stockvelAddress(stockvelAddress)
                .stockvelContact(stockvelContact)
                .isBeneficiary(false)
                .copy(submember)
                .build();
        
        Assert.assertTrue(submember.isBeneficiary());
        Assert.assertFalse(copiedsubmember.isBeneficiary());
     
    }
}
