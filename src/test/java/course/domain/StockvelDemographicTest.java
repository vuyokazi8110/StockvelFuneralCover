/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import course.conf.factory.StockvelDemographicFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author sbm
 */
public class StockvelDemographicTest {
    
    
    
   @Test
    public void testCreateDemographic() throws Exception {
        
        StockvelDemographic demographic = StockvelDemographicFactory
                .createDemographic("Female", "Other", "8501300075081");
                
        
        Assert.assertEquals("8501300075081",demographic.getIdNumber());
    }

    @Test
    public void testUpdateDemographic() throws Exception {
       StockvelDemographic demographic = StockvelDemographicFactory
                .createDemographic("Female", "Other", "8501300075081");

        StockvelDemographic copiedDemographic = new StockvelDemographic
                .Builder("8105300075081")
                .Gender("Female")
                .race("Black")
                .copy(demographic)
                .build();
        
        Assert.assertEquals("8501300075081",demographic.getIdNumber());
        Assert.assertEquals("8105300075081",copiedDemographic.getIdNumber());
        Assert.assertEquals("Female",demographic.getGender());
        Assert.assertEquals("Female",copiedDemographic.getGender());
        Assert.assertEquals("Other",demographic.getRace());
        Assert.assertEquals("Black",copiedDemographic.getRace());
       

    }
}
