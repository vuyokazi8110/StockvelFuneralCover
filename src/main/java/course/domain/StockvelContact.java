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
public class StockvelContact implements Serializable{
    
    private String email;
    private String homephoneNumber;
    private String cellNumber;
    

    private StockvelContact(Builder build) {
    this.email= build.email;
    this.cellNumber = build.cellNumber;
    this.homephoneNumber = build.homephoneNumber;
     
    }
    
    private StockvelContact() {
     
    }

    
    public static class Builder{
        
        private String email;
        private String homephoneNumber;
        private String cellNumber;
                
       
        public Builder (String email)
        {
            this.email=email;
        }
        
        public Builder HomeNumber(String homephoneNumber)
        {
            this.homephoneNumber = homephoneNumber;
            return this;
        }
         public Builder CellNumber(String CellNumber)
        {
            this.cellNumber = CellNumber;
            return this;
        }  
       
        public Builder copy(StockvelContact value){
            this.homephoneNumber=value.homephoneNumber;
            this.cellNumber=value.cellNumber;
            this.email=value.email;
            return this;
        }
        
        public StockvelContact build()
        {
            return new StockvelContact(this);
        }
    }
    
    public String getEmail() {
            return email;
     }

    public String getHomeNumber() {
        return homephoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }
    
}
