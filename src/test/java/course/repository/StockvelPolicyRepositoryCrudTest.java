/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.conf.factory.StockvelPolicyFactory;
import course.domain.StockvelPolicy;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sbm
 */
public class StockvelPolicyRepositoryCrudTest {
    
    private Long id;

    @Autowired
    private StockvelPolicyRepository repository;

   @Test
    public void create() throws Exception {
        
            
         StockvelPolicy policy = StockvelPolicyFactory
                .createPolicy(123345, "Stockvel Life Cover", 580.00);
        
        repository.save(policy);
        id=policy.getId();
        
        Assert.assertNotNull(policy);
    }

   @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelPolicy policy = repository.findOne(id);
        Assert.assertNotNull(policy.getId());
        Assert.assertEquals(123345,policy.getPolicyNo());
        
        
    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelPolicy policy = repository.findOne(id);

        StockvelPolicy newpolicy = new StockvelPolicy
                .Builder(policy.getPolicyNo())
                .policyName(policy.getPolicyName())
                .premium(850.00)
                .copy(policy)
                .build();

        repository.save(newpolicy);

        StockvelPolicy updatedPolicy = repository.findOne(id);
        Assert.assertEquals(850.00,updatedPolicy.getPremium(),0);

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelPolicy policy = repository.findOne(id);
        repository.delete(policy);
        StockvelPolicy deletedPolicy = repository.findOne(id);
        Assert.assertNull(deletedPolicy);

    }
}
