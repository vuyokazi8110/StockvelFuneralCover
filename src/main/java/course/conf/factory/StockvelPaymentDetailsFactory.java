/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelMainMember;
import course.domain.StockvelPaymentDetails;
import course.domain.StockvelPolicy;

/**
 *
 * @author sbm
 */
public class StockvelPaymentDetailsFactory {
    
    public static StockvelPaymentDetails createPaymentDetails(StockvelPolicy stockvelPolicy,
       double amountPaid){
        
        StockvelPaymentDetails paymentDetails = new StockvelPaymentDetails
                .Builder()
                .stockvelPolicy(stockvelPolicy)
                .amountPaid(amountPaid)
                .build();
        
        return paymentDetails;
    }
    
}
