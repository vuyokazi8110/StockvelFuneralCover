package course.repository;

import course.App;
import course.conf.factory.StockvelClaimFactory;
import course.domain.StockvelClaim;
import course.domain.StockvelPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelClaimRepositoryCrudTest extends AbstractTestNGSpringContextTests{

    private Long id;

    
    StockvelPolicy stockvelPolicy;

    @Autowired
    StockvelClaimRepository repository;
    
    @Autowired
    StockvelPolicyRepository repositoryPolicy;

    @BeforeMethod
    public void setUp() throws Exception {
        

    }

    @AfterMethod
    public void tearDown() throws Exception {
//        repository.deleteAll();

    }

   @Test
    public void create() throws Exception {

       stockvelPolicy = new StockvelPolicy
                .Builder(123355)
                .policyName("Stockvel funeral")
                .premium(350.00)
                .build();
          
         repositoryPolicy.save(stockvelPolicy);
         //id = stockvelPolicy.getId();
         
          StockvelClaim claim = StockvelClaimFactory
                .createClaim("Stockvel001",stockvelPolicy);
        
        repository.save(claim);
        id=claim.getId();
        
        Assert.assertNotNull(claim);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        StockvelClaim claim = repository.findOne(id);
        Assert.assertNotNull(claim.getId());

    }

   // @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        
        StockvelClaim claim = repository.findOne(id);

        StockvelClaim newclaim = new StockvelClaim
                .Builder("STKV001")
                .copy(claim)
                .stockvelPolicy(claim.getStockvelPolicy())
                .build();

        repository.save(newclaim);

       StockvelClaim updatedClaim = repository.findOne(id);
       Assert.assertEquals(updatedClaim.getClaimNumber(),"STKV001");

    }

 //   @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelClaim claim = repository.findOne(id);
        repository.delete(claim);
        StockvelClaim deletedClaim = repository.findOne(id);
        Assert.assertNull(deletedClaim);

    }


}
