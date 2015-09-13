/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.App;
import course.conf.factory.StockvelClaimFactory;
import course.domain.StockvelClaim;
import course.domain.StockvelFullname;
import course.domain.StockvelMainMember;
import course.domain.StockvelPolicy;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 *
 * @author sbm
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelClaimRepositoryCrudTest {
    
    private Long id;

    @Autowired
    private StockvelClaimRepository repository;

   @Test
    public void create() throws Exception {
        
        StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Vuyo")
                .lastName("Wando")
                .build();
        
        StockvelMainMember stockvelMainMember = new StockvelMainMember.Builder()
                .stokvelFullname(stokvelFullname)
                .build();
        
        
        StockvelPolicy stockvelPolicy = new StockvelPolicy
                .Builder(123355)
                .policyName("Stockvel funeral")
                .premium(350.00)
                .build();
          
         
            
        StockvelClaim claim = StockvelClaimFactory
                .createClaim("Stockvel001",stockvelMainMember,stockvelPolicy);
        
        repository.save(claim);
        id=claim.getId();
        
        Assert.assertNotNull(claim);
    }

   @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelClaim claim = repository.findOne(id);
        Assert.assertNotNull(claim.getId());
        Assert.assertEquals("Stockvel001",claim.getClaimNumber());
        
        
    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelClaim claim = repository.findOne(id);

        StockvelClaim newclaim = new StockvelClaim
                .Builder(claim.getClaimNumber())
                .stockvelMainMember(claim.getStockvelMainMember())
                .stockvelPolicy(claim.getStockvelPolicy())
                .copy(claim)
                .build();

        repository.save(newclaim);

        StockvelClaim updatedClaim = repository.findOne(id);
        Assert.assertEquals("Stockvel001",updatedClaim.getClaimNumber());

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelClaim claim = repository.findOne(id);
        repository.delete(claim);
        StockvelClaim deletedClaim = repository.findOne(id);
        Assert.assertNull(deletedClaim);

    }
}
