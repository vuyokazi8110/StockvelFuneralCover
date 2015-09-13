/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelPaymentDetailsFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelPaymentDetailsTest 
{
         
   @Test
    public void testCreatePaymentDetails() throws Exception {
        
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
        
        Assert.assertEquals(600.00,paymentDetails.getAmountPaid(), 0);
    }

    @Test
    public void testUpdatePaymentDetails() throws Exception {
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
        
        
        StockvelPaymentDetails copiedPaymentDetails = new StockvelPaymentDetails
                .Builder()
                .stockvelMainMember(stockvelMainMember)
                .stockvelPolicy(stockvelPolicy)
                .amountPaid(700.00)
                .build();
        
        Assert.assertEquals(600.00,paymentDetails.getAmountPaid(), 0);
        Assert.assertEquals(700.00,copiedPaymentDetails.getAmountPaid(), 0);
        

    }   
}
