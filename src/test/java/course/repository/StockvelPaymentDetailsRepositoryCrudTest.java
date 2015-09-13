/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.App;
import course.conf.factory.StockvelPaymentDetailsFactory;
import course.domain.StockvelPaymentDetails;
import course.domain.StockvelPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelPaymentDetailsRepositoryCrudTest extends AbstractTestNGSpringContextTests{
    
    private Long id;

    @Autowired
    private StockvelPaymentDetailsRepository repository;
    
    @Autowired
    private StockvelPolicyRepository repositoryPolicy;

   @Test
    public void create() throws Exception {
        
       
       StockvelPolicy stockvelPolicy = new StockvelPolicy.Builder(123456)
               .policyName("Stockvel Saver")
               .premium(580.00)
               .build();
       
       repositoryPolicy.save(stockvelPolicy);
       
    
        StockvelPaymentDetails paymentDetails = StockvelPaymentDetailsFactory
                .createPaymentDetails(stockvelPolicy, 
                600.00);
        
        repository.save(paymentDetails);
        id=paymentDetails.getId();
        
        Assert.assertNotNull(paymentDetails);
    }

   @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelPaymentDetails paymentDetails = repository.findOne(id);
        Assert.assertNotNull(paymentDetails.getId());
       
        
        
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelPaymentDetails paymentDetails = repository.findOne(id);

        StockvelPaymentDetails newPaymentDetails = new StockvelPaymentDetails
                .Builder()
                .stockvelPolicy(paymentDetails.getStockvelPolicy())
                .copy(paymentDetails)
                .amountPaid(800.00)
                .build();

        repository.save(newPaymentDetails);

        StockvelPaymentDetails updatedPaymentDetails = repository.findOne(id);
        Assert.assertEquals(800.00,updatedPaymentDetails.getAmountPaid(), 0);

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelPaymentDetails paymentDetails = repository.findOne(id);
        repository.delete(paymentDetails);
        StockvelPaymentDetails deletedPaymentDetails = repository.findOne(id);
        Assert.assertNull(deletedPaymentDetails);

    }
}
