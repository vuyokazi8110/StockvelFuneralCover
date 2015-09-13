/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelAddress;

/**
 *
 * @author sbm
 */
public class StockvelAddressFactory {
    
    public static StockvelAddress createAddress(String streetNo, String streetName, String suburb, String code){

        StockvelAddress address = new StockvelAddress
                .Builder()
                .streetNo(streetNo)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(code)
                .build();
        
        return address;
    }
    
}
