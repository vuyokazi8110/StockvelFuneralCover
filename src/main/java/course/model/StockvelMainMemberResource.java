/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.model;

import course.domain.StockvelAddress;
import course.domain.StockvelClaim;
import course.domain.StockvelContact;
import course.domain.StockvelDemographic;
import course.domain.StockvelFullname;
import course.domain.StockvelMainMember;
import course.domain.StockvelPaymentDetails;
import course.domain.StockvelPolicy;
import course.domain.StockvelSubmember;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author sbm
 */
public class StockvelMainMemberResource extends ResourceSupport{
    
    private StockvelFullname stokvelFullname;
    private StockvelDemographic stockvelDemographic;
    private StockvelAddress stockvelAddress;
    private StockvelContact stockvelContact;
    private List<StockvelSubmember> stockvelSubmember;
    private List<StockvelPolicy> stockvelPolicy;
    private List<StockvelClaim> stockvelClaim;
    private List<StockvelPaymentDetails> stockvelPaymentDetails;

    
   
    private StockvelMainMemberResource()
    {
        
    }
    
    private StockvelMainMemberResource (Builder build){
        stokvelFullname = build. stokvelFullname;
        stockvelDemographic = build.stockvelDemographic;
        stockvelAddress = build.stockvelAddress;
        stockvelContact = build.stockvelContact; 
        stockvelSubmember =build.stockvelSubmember;
        stockvelPolicy = build.stockvelPolicy;
        stockvelClaim = build.stockvelClaim;
        stockvelPaymentDetails = build.stockvelPaymentDetails;
    }
    
   
    
    public static class Builder{
        
    private Long id;
    private StockvelFullname stokvelFullname;
    private StockvelDemographic stockvelDemographic;
    private StockvelAddress stockvelAddress;
    private StockvelContact stockvelContact;
    private List<StockvelSubmember>stockvelSubmember;
    private List<StockvelPolicy> stockvelPolicy;
    private List<StockvelClaim> stockvelClaim;
    private List<StockvelPaymentDetails> stockvelPaymentDetails;

        
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
        
        public Builder stockvelSubmember(List<StockvelSubmember> stockvelSubmember)
        {
            this.stockvelSubmember = stockvelSubmember;
            return this;
        }
        
        public Builder stockvelPolicy(List<StockvelPolicy> stockvelPolicy)
        {
            this.stockvelPolicy = stockvelPolicy;
            return this;
        }
        
        public Builder stockvelClaim(List<StockvelClaim> stockvelClaim)
        {
            this.stockvelClaim = stockvelClaim;
            return this;
        }
        
        public Builder stockvelPaymentDetails(List<StockvelPaymentDetails> stockvelPaymentDetails)
        {
            this.stockvelPaymentDetails = stockvelPaymentDetails;
            return this;
        }
    
    
    public Builder copy(StockvelMainMemberResource value) {
        
            this.stokvelFullname = value.stokvelFullname;
            this.stockvelDemographic = value.stockvelDemographic;
            this.stockvelAddress = value.stockvelAddress;
            this.stockvelContact = value.stockvelContact;
            this.stockvelSubmember = value.stockvelSubmember;
            this.stockvelPolicy = value.stockvelPolicy;
            this.stockvelClaim = value.stockvelClaim;
            this.stockvelPaymentDetails = value.stockvelPaymentDetails;
            return this;
        }
    
        public StockvelMainMemberResource build() {
                return new StockvelMainMemberResource(this);
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
    
    public List<StockvelSubmember> getStockvelSubmember() {
       return stockvelSubmember;
    }
     
    public List<StockvelPolicy> getStockvelPolicy() {
      return stockvelPolicy;
    }
    
    public List<StockvelClaim> getStockvelClaim() {
        return stockvelClaim;
    }
    
    public List<StockvelPaymentDetails> getStockvelPaymentDetails() {
        return stockvelPaymentDetails;
    }

   
    
}
