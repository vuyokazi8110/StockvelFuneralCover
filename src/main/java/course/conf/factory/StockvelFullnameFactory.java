/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelFullname;

/**
 *
 * @author sbm
 */
public class StockvelFullnameFactory {
    
     public static StockvelFullname createFullname(String firstName, String lastName){

        StockvelFullname fullname = new StockvelFullname
                .Builder(firstName)
                .lastName(lastName)
                .build();
        
        return fullname;
    }
    
}
