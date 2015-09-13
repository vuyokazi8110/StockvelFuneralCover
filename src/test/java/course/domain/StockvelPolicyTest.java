/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelPolicyFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelPolicyTest {
    
    @Test
    public void testCreatePolicy() throws Exception {
        
        StockvelPolicy policy = StockvelPolicyFactory
                .createPolicy(123345, "Stockvel Life Cover", 580.00);
        
        
        Assert.assertEquals("Stockvel Life Cover",policy.getPolicyName());
    }

    @Test
    public void testUpdatePolicy() throws Exception {
        
        StockvelPolicy policy = StockvelPolicyFactory
                .createPolicy(123345, "Stockvel Life Cover", 580.00);
        
        StockvelPolicy copiedpolicy = new StockvelPolicy
                .Builder(123345)
                .policyName("Stock Life Cover")
                .premium(580.00)
                .copy(policy)
                .build();
        
        Assert.assertEquals("Stockvel Life Cover",policy.getPolicyName());
        Assert.assertEquals("Stock Life Cover",copiedpolicy.getPolicyName());
        

    }
}
