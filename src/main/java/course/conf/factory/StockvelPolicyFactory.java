/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelPolicy;

/**
 *
 * @author sbm
 */
public class StockvelPolicyFactory {
    
     public static StockvelPolicy createPolicy(int policyNo,
            String policyName,
            double premium){

        StockvelPolicy policy = new StockvelPolicy
                .Builder(policyNo)
                .policyName(policyName)
                .premium(policyNo)
                .build();
        
        return policy;
    }
    
}
