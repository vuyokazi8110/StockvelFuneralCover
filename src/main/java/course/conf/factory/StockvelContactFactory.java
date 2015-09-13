/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelContact;

/**
 *
 * @author sbm
 */
public class StockvelContactFactory {
   
    public static StockvelContact createContact(String email,
            String homephoneNumber,
            String cellNumber){

        StockvelContact contact = new StockvelContact
                .Builder(email)
                .CellNumber(cellNumber)
                .HomeNumber(homephoneNumber)
                .build();
        
        return contact;
    }
    
}
