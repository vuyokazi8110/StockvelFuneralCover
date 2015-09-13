/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.App;
import course.conf.factory.StockvelPaymentDetailsFactory;
import course.domain.StockvelFullname;
import course.domain.StockvelMainMember;
import course.domain.StockvelPaymentDetails;
import course.domain.StockvelPolicy;
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
public class StockvelPaymentDetailsRepositoryCrudTest {
    
    private Long id;

    @Autowired
    private StockvelPaymentDetailsRepository repository;

   @Test
    public void create() throws Exception {
        
       
         StockvelFullname fullname = new StockvelFullname.Builder("Vuyo")
               .lastName("Wondo")
               .build();
        
       StockvelMainMember stockvelMainMember = new StockvelMainMember
               .Builder()
               .stokvelFullname(fullname)
               .build();
       
       StockvelPolicy stockvelPolicy = new StockvelPolicy.Builder(123456)
               .policyName("Stockvel Saver")
               .premium(580.00)
               .build();
       
    
        StockvelPaymentDetails paymentDetails = StockvelPaymentDetailsFactory
                .createPaymentDetails(stockvelMainMember, 
                stockvelPolicy, 
                600.00);
        
        repository.save(paymentDetails);
        id=paymentDetails.getId();
        
        Assert.assertNotNull(paymentDetails);
    }

   @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelPaymentDetails paymentDetails = repository.findOne(id);
        Assert.assertNotNull(paymentDetails.getId());
        Assert.assertEquals(600.00,paymentDetails.getAmountPaid(), 0);
        
        
    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelPaymentDetails paymentDetails = repository.findOne(id);

        StockvelPaymentDetails newPaymentDetails = new StockvelPaymentDetails
                .Builder()
                .stockvelMainMember(paymentDetails.getStockvelMainMember())
                .stockvelPolicy(paymentDetails.getStockvelPolicy())
                .amountPaid(800.00)
                .copy(paymentDetails)
                .build();

        repository.save(newPaymentDetails);

        StockvelPaymentDetails updatedPaymentDetails = repository.findOne(id);
        Assert.assertEquals(800.00,updatedPaymentDetails.getAmountPaid(), 0);

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelPaymentDetails paymentDetails = repository.findOne(id);
        repository.delete(paymentDetails);
        StockvelPaymentDetails deletedPaymentDetails = repository.findOne(id);
        Assert.assertNull(deletedPaymentDetails);

    }
}
