/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sbm
 */
@Entity
public class StockvelSubmember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    private StockvelFullname stokvelFullname;
    
    @Embedded
    private StockvelDemographic stockvelDemographic;
    
    @Embedded
    private StockvelAddress stockvelAddress;
    
    @Embedded
    private StockvelContact stockvelContact;
    
    private boolean isBeneficiary;

   
    private StockvelSubmember()
    {
        
    }
    
    private StockvelSubmember (Builder build){
        id = build.id;
        stokvelFullname = build. stokvelFullname;
        stockvelDemographic = build.stockvelDemographic;
        stockvelAddress = build.stockvelAddress;
        stockvelContact = build.stockvelContact; 
        isBeneficiary = build.isBeneficiary;
    }
    
   
    
    public static class Builder{
        
    private Long id;
    private StockvelFullname stokvelFullname;
    private StockvelDemographic stockvelDemographic;
    private StockvelAddress stockvelAddress;
    private StockvelContact stockvelContact;
    private boolean isBeneficiary;
        
        
        public Builder()
        {
            
        }
        
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        
        public Builder stokvelFullname(StockvelFullname stokvelFullname)
        {
            this.stokvelFullname = stokvelFullname;
            return this;
        }  
        
        public Builder stockvelDemographic(StockvelDemographic stockvelDemographic)
        {
            this.stockvelDemographic = stockvelDemographic;
            return this;
        } 
         
        public Builder stockvelAddress(StockvelAddress stockvelAddress)
        {
            this.stockvelAddress = stockvelAddress;
            return this;
        } 
        
        public Builder stockvelContact(StockvelContact stockvelContact)
        {
            this.stockvelContact = stockvelContact;
            return this;
        } 
        
        public Builder isBeneficiary(boolean isBeneficiary)
        {
            this.isBeneficiary = isBeneficiary;
            return this;
        }
    
    
    public Builder copy(StockvelSubmember value) {
        
            this.id = value.id;
            this.stokvelFullname = value.stokvelFullname;
            this.stockvelDemographic = value.stockvelDemographic;
            this.stockvelAddress = value.stockvelAddress;
            this.stockvelContact = value.stockvelContact;
            this.isBeneficiary = value.isBeneficiary;
            return this;
        }
    
        public StockvelSubmember build() {
                return new StockvelSubmember(this);
        }
    } 
    
     public StockvelFullname getStokvelFullname() {
        return stokvelFullname;
    }

    public StockvelDemographic getStockvelDemographic() {
        return stockvelDemographic;
    }

    public StockvelAddress getStockvelAddress() {
        return stockvelAddress;
    }

    public StockvelContact getStockvelContact() {
        return stockvelContact;
    }

    public Long getId() {
        return id;
    }
    
     public boolean isBeneficiary() {
        return isBeneficiary;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockvelSubmember)) {
            return false;
        }
        StockvelSubmember other = (StockvelSubmember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "course.domain.StockvelSubmember[ id=" + id + " ]";
    }
    
}
