/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelClaim;
import course.domain.StockvelMainMember;
import course.domain.StockvelPolicy;
import java.util.List;

/**
 *
 * @author sbm
 */
public class StockvelClaimFactory {
    
    public static StockvelClaim createClaim(String claimNumber,
            StockvelPolicy stockvelPolicy){
        
        StockvelClaim claim = new StockvelClaim
                .Builder(claimNumber)
                .stockvelPolicy(stockvelPolicy)
                .build();
        
        return claim;
    }
    
}
