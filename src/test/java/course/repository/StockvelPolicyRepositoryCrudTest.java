/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.App;
import course.conf.factory.StockvelPolicyFactory;
import course.domain.StockvelPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelPolicyRepositoryCrudTest extends AbstractTestNGSpringContextTests{
    
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

   @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelPolicy policy = repository.findOne(id);
        Assert.assertNotNull(policy.getId());
       
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelPolicy policy = repository.findOne(id);

        StockvelPolicy newpolicy = new StockvelPolicy
                .Builder(policy.getPolicyNo())
                .policyName(policy.getPolicyName())
                .copy(policy)
                .premium(850.00)
                .build();

        repository.save(newpolicy);

        StockvelPolicy updatedPolicy = repository.findOne(id);
        Assert.assertEquals(850.00,updatedPolicy.getPremium(),0);

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelPolicy policy = repository.findOne(id);
        repository.delete(policy);
        StockvelPolicy deletedPolicy = repository.findOne(id);
        Assert.assertNull(deletedPolicy);

    }
}
