/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelPaymentDetailsFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelPaymentDetailsTest 
{
         
   @Test
    public void testCreatePaymentDetails() throws Exception {
        
       
       StockvelPolicy stockvelPolicy = new StockvelPolicy.Builder(123456)
               .policyName("Stockvel Saver")
               .premium(580.00)
               .build();
       
       
       
    
        StockvelPaymentDetails paymentDetails = StockvelPaymentDetailsFactory
                .createPaymentDetails(stockvelPolicy, 
                600.00);
        
        Assert.assertEquals(600.00,paymentDetails.getAmountPaid(), 0);
    }

    @Test
    public void testUpdatePaymentDetails() throws Exception {
       
       
       StockvelPolicy stockvelPolicy = new StockvelPolicy.Builder(123456)
               .policyName("Stockvel Saver")
               .premium(580.00)
               .build();
       
    
        StockvelPaymentDetails paymentDetails = StockvelPaymentDetailsFactory
                .createPaymentDetails(stockvelPolicy, 
                600.00);
        
        
        StockvelPaymentDetails copiedPaymentDetails = new StockvelPaymentDetails
                .Builder()
                .stockvelPolicy(stockvelPolicy)
                .amountPaid(700.00)
                .build();
        
        Assert.assertEquals(600.00,paymentDetails.getAmountPaid(), 0);
        Assert.assertEquals(700.00,copiedPaymentDetails.getAmountPaid(), 0);
        

    }   
}
