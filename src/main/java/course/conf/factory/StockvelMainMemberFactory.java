/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelAddress;
import course.domain.StockvelClaim;
import course.domain.StockvelContact;
import course.domain.StockvelDemographic;
import course.domain.StockvelFullname;
import course.domain.StockvelMainMember;
import course.domain.StockvelPolicy;
import course.domain.StockvelSubmember;
import java.util.List;

/**
 *
 * @author sbm
 */
public class StockvelMainMemberFactory {
    
    public static StockvelMainMember createMainMember(StockvelFullname stokvelFullname,
            StockvelDemographic stockvelDemographic,
            StockvelAddress stockvelAddress,
            StockvelContact stockvelContact,
            List<StockvelSubmember>stockvelSubmember,
            List<StockvelPolicy> stockvelPolicy,
            List<StockvelClaim> stockvelClaim){

        StockvelMainMember mainMember = new StockvelMainMember
                .Builder()
                .stokvelFullname(stokvelFullname)
                .stockvelDemographic(stockvelDemographic)
                .stockvelAddress(stockvelAddress)
                .stockvelContact(stockvelContact)
                .stockvelPolicy(stockvelPolicy)
                .stockvelSubmember(stockvelSubmember)
                .stockvelClaim(stockvelClaim)
                .build();
        
        return mainMember;
    }
    
    
}
