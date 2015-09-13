/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelMainMemberFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelMainMemberTest {
    
    
        
    @Test
    public void testCreateMainMember() throws Exception {
        
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
        
        List<StockvelSubmember>stockvelSubmember = new ArrayList<>();
        List<StockvelPolicy> stockvelPolicy = new ArrayList<>();
        List<StockvelClaim> stockvelClaim = new ArrayList<>();
                
        StockvelMainMember mainMember = StockvelMainMemberFactory
                .createMainMember(stokvelFullname, 
                        stockvelDemographic, 
                        stockvelAddress, 
                        stockvelContact, 
                        stockvelSubmember, 
                        stockvelPolicy,
                        stockvelClaim);
        
        Assert.assertEquals("Vuyo",mainMember.getStokvelFullname().getFirstName());
    }

    @Test
    public void testUpdateMainMember() throws Exception {
        
        
        StockvelFullname stokvelFullnameCreate = new StockvelFullname
                .Builder("VuyoKazi")
                .build();
        
        StockvelFullname stokvelFullnameUpdate = new StockvelFullname
                .Builder("VuyoKazi")
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
        
        List<StockvelSubmember>stockvelSubmember = new ArrayList<>();
        List<StockvelPolicy> stockvelPolicy = new ArrayList<>();
        List<StockvelClaim> stockvelClaim = new ArrayList<>();
                
        StockvelMainMember mainMember = StockvelMainMemberFactory
                .createMainMember(stokvelFullnameCreate, 
                        stockvelDemographic, 
                        stockvelAddress, 
                        stockvelContact, 
                        stockvelSubmember, 
                        stockvelPolicy,
                        stockvelClaim);
        
        

        StockvelMainMember copiedMainMember = new StockvelMainMember
                .Builder()
                .stokvelFullname(stokvelFullnameUpdate)
                .stockvelDemographic(stockvelDemographic)
                .stockvelAddress(stockvelAddress)
                .stockvelContact(stockvelContact)
                .stockvelSubmember(stockvelSubmember)
                .stockvelPolicy(stockvelPolicy)
                .stockvelClaim(stockvelClaim)
                .copy(mainMember)
                .build();
        
        Assert.assertEquals("Vuyo",mainMember.getStokvelFullname().getFirstName());
        Assert.assertEquals("Vuyokazi",copiedMainMember.getStokvelFullname().getFirstName());
     
    }
}
