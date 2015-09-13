/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author sbm
 */
@Entity
public class StockvelClaim implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String claimNumber;
    
    
    @OneToOne
    @JoinColumn(name="Policy_Id")
    private StockvelPolicy stockvelPolicy;

    private StockvelClaim(Builder build) 
    {
        id = build.id;
        claimNumber= build.claimNumber;
        stockvelPolicy = build.stockvelPolicy;
    
    }
    
    private StockvelClaim() 
    {
       
    }
    
    
    public static class Builder{
        
        private Long id;
        private String claimNumber;
        private StockvelPolicy stockvelPolicy;
       
        public Builder (String claimNumber)
        {
            this.claimNumber = claimNumber;
        }
        
        
        public Builder stockvelPolicy(StockvelPolicy stockvelPolicy)
        {
            this.stockvelPolicy = stockvelPolicy;
            return this;
        }
        
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        
         public StockvelClaim build()
        {
            return new StockvelClaim(this);
        }

        
         public Builder copy(StockvelClaim value){
            this.id = value.id;
            this.claimNumber= value.claimNumber;
            this.stockvelPolicy = value.stockvelPolicy;
            return null;        
         }
        
    }
    
    public String getClaimNumber() {
        return claimNumber;
    }

    
    
    public StockvelPolicy getStockvelPolicy() {
        return stockvelPolicy;
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
        if (!(object instanceof StockvelClaim)) {
            return false;
        }
        StockvelClaim other = (StockvelClaim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "course.domain.Claims[ id=" + id + " ]";
    }
    
}
