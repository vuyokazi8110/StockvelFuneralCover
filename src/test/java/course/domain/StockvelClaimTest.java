/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelClaimFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author sbm
 */
public class StockvelClaimTest {
    
    @Test
    public void testCreateClaim() throws Exception {
        StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Vuyo")
                .lastName("wando")
                .build();
        
        StockvelMainMember stockvelMainMember = new StockvelMainMember.Builder()
                .stokvelFullname(stokvelFullname)
                .build();
        
        StockvelPolicy stockvelPolicy = new StockvelPolicy
                .Builder(123456)
                .policyName("Stockvel Death")
                .premium(250.00)
                .build();
            
        StockvelClaim claim = StockvelClaimFactory
                .createClaim("Stockvel2001",stockvelMainMember,stockvelPolicy);
        
        Assert.assertEquals("Stockvel2001",claim.getClaimNumber());
    }

    @Test
    public void testUpdateClaim() throws Exception {
        
        StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Vuyo")
                .lastName("wando")
                .build();
        
        StockvelMainMember stockvelMainMember = new StockvelMainMember.Builder()
                .stokvelFullname(stokvelFullname)
                .build();
        
        StockvelPolicy stockvelPolicy = new StockvelPolicy
                .Builder(123456)
                .policyName("Stockvel Death")
                .premium(250.00)
                .build();
            
        StockvelClaim claim = StockvelClaimFactory
                .createClaim("Stockvel2001",stockvelMainMember,stockvelPolicy);

        StockvelClaim copiedClaim = new StockvelClaim
                .Builder("STV2001")
                .stockvelMainMember(stockvelMainMember)
                .stockvelPolicy(stockvelPolicy)
                .copy(claim)
                .build();
        
        Assert.assertEquals("Stockvel2001",claim.getClaimNumber());
        Assert.assertEquals("STV2001",copiedClaim.getClaimNumber());
        
       

    }
    
}
