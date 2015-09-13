/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.conf.factory;

import course.domain.StockvelDemographic;

/**
 *
 * @author sbm
 */
public class StockvelDemographicFactory {
    
    public static StockvelDemographic createDemographic(String gender, String  race, String idNumber){

        StockvelDemographic demographic = new StockvelDemographic
                .Builder(idNumber)
                .race(race)
                .Gender(gender)
                .build();
        
        return demographic;
    }
    
}
