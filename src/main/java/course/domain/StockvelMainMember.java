/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author sbm
 */
@Entity
public class StockvelMainMember implements Serializable {
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
    
    @OneToMany
    @JoinColumn(name="sub_id")
    private List<StockvelSubmember> stockvelSubmember;

    @OneToMany
    @JoinColumn(name="policy_number")
    private List<StockvelPolicy> stockvelPolicy;
    
    @OneToMany
    @JoinColumn(name="claim_number")
    private List<StockvelClaim> stockvelClaim;

    
   
    private StockvelMainMember()
    {
        
    }
    
    private StockvelMainMember (Builder build){
        id = build.id;
        stokvelFullname = build. stokvelFullname;
        stockvelDemographic = build.stockvelDemographic;
        stockvelAddress = build.stockvelAddress;
        stockvelContact = build.stockvelContact; 
        stockvelSubmember =build.stockvelSubmember;
        stockvelPolicy = build.stockvelPolicy;
        stockvelClaim = build.stockvelClaim;
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
    
    
    public Builder copy(StockvelMainMember value) {
        
            this.id = value.id;
            this.stokvelFullname = value.stokvelFullname;
            this.stockvelDemographic = value.stockvelDemographic;
            this.stockvelAddress = value.stockvelAddress;
            this.stockvelContact = value.stockvelContact;
            this.stockvelSubmember = value.stockvelSubmember;
            this.stockvelPolicy = value.stockvelPolicy;
            this.stockvelClaim = value.stockvelClaim;
            return this;
        }
    
        public StockvelMainMember build() {
                return new StockvelMainMember(this);
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

    public Long getId() {
        return id;
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
        if (!(object instanceof StockvelMainMember)) {
            return false;
        }
        StockvelMainMember other = (StockvelMainMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "course.domain.StockvelMainMember[ id=" + id + " ]";
    }
    
}
