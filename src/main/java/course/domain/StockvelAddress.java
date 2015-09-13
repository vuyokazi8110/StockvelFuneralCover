/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author sbm
 */
@Embeddable
public class StockvelAddress implements Serializable{
    
    private String streetNo;
    private String streetName;
    private String suburb;
    private String postalCode;

    private StockvelAddress (Builder build){
        
        streetNo = build. streetNo;
        streetName = build.streetName;
        suburb = build.suburb;
        postalCode = build.postalCode;        
    }
    
    private StockvelAddress(){
        
    }
    
    public static class Builder{
        
        private String streetNo;
        private String streetName;
        private String suburb;
        private String postalCode;
        
        
        public Builder streetNo(String streetNo)
        {
            this.streetNo = streetNo;
            return this;
        }
        
        public Builder streetName(String streetName)
        {
            this.streetName = streetName;
            return this;
        }  
        
        public Builder suburb(String suburb)
        {
            this.suburb = suburb;
            return this;
        } 
         
        public Builder postalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        } 
    
    
    public Builder copy(StockvelAddress value) {
        
            this.streetNo = value.streetNo;
            this.streetName = value.streetName;
            this.suburb = value.suburb;
            this.postalCode = value.postalCode;
            return this;
        }
    
        public StockvelAddress build() {
                return new StockvelAddress(this);
        }
    } 
    
     public String getStreetNo() {
        return streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }
    
       
}
