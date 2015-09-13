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
public class StockvelFullname {
    
    private String firstName;
    private String lastName;

   
    private StockvelFullname (Builder build){
        this.firstName = build.firstName;
        this.lastName = build.lastName;
    }
    
    private StockvelFullname (){
        
    }
    
    public static class Builder {
            
        private String firstName;
        private String lastName;

         
        public Builder (String firstName){
            this.firstName = firstName;
           
        }  
        
        public Builder lastName(String lastName){
         this.lastName=lastName;
            return this;
       }
       
        public Builder copy(StockvelFullname value){
            this.firstName=value.firstName;
            this.lastName=value.lastName;
            return this;
        }

        public StockvelFullname build(){
            return new StockvelFullname(this);
        }
    }
        
     public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
}
