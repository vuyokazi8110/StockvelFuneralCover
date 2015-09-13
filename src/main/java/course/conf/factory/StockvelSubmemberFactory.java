/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelAddress;
import course.domain.StockvelContact;
import course.domain.StockvelDemographic;
import course.domain.StockvelFullname;
import course.domain.StockvelSubmember;

/**
 *
 * @author sbm
 */
public class StockvelSubmemberFactory {
    
    public static StockvelSubmember createSubmember(StockvelFullname stokvelFullname,
            StockvelDemographic stockvelDemographic,
            StockvelAddress stockvelAddress,
            StockvelContact stockvelContact,
            boolean isBeneficiary){

        StockvelSubmember submember = new StockvelSubmember
                .Builder()
                .stokvelFullname(stokvelFullname)
                .stockvelDemographic(stockvelDemographic)
                .stockvelAddress(stockvelAddress)
                .stockvelContact(stockvelContact)
                .isBeneficiary(isBeneficiary)
                .build();
        
        return submember;
    }
    
}
