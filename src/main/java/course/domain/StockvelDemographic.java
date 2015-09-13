/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author sbm
 */
@Embeddable
public class StockvelDemographic {
    
    private String gender;
    private String  race;
    private String idNumber;

    
    
    private StockvelDemographic (Builder build)
    {
        this.gender = build.gender;
        this.race = build.race;
        this.idNumber = build.idNumber;
    }
    
    private StockvelDemographic()
    {
        
    }
    
    public static class Builder{
        
        private String gender;
        private String  race;
        private String idNumber;

        public Builder(String idNumber) {
           this.idNumber = idNumber;
        }
    
        public Builder race(String race)
        {
            this.race = race;
           return this;
        
        }
        
        public Builder Gender(String gender)
        {
            this.gender = gender;
           return this;
        
        }
        
        public Builder copy(StockvelDemographic value){
            this.gender=value.gender;
            this.race=value.race;
            this.idNumber=value.idNumber;
            return this;
        }
        
        public StockvelDemographic build()
        {
            return new StockvelDemographic(this);
        }
       
  }
    
    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }
    
    public String getIdNumber() {
        return idNumber;
    }
    
}
