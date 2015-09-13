/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelClaimFactory;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author sbm
 */
public class StockvelClaimTest {
    
    @Test
    public void testCreateClaim() throws Exception {
       
        
        StockvelPolicy stockvelPolicy = new StockvelPolicy
                .Builder(123456)
                .policyName("Stockvel Death")
                .premium(250.00)
                .build();
        
            
        StockvelClaim claim = StockvelClaimFactory
                .createClaim("Stockvel2001",stockvelPolicy);
        
        Assert.assertEquals("Stockvel2001",claim.getClaimNumber());
    }

    @Test
    public void testUpdateClaim() throws Exception {
        
        StockvelPolicy stockvelPolicy = new StockvelPolicy
                .Builder(123456)
                .policyName("Stockvel Death")
                .premium(250.00)
                .build();
            
        StockvelClaim claim = StockvelClaimFactory
                .createClaim("Stockvel2001",stockvelPolicy);

        StockvelClaim copiedClaim = new StockvelClaim
                .Builder("STV2001")
                .stockvelPolicy(stockvelPolicy)
                .copy(claim)
                .build();
        
        Assert.assertEquals("Stockvel2001",claim.getClaimNumber());
        Assert.assertEquals("STV2001",copiedClaim.getClaimNumber());
        
       

    }
    
}
