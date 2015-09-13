/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author sbm
 */
@Entity
public class StockvelPaymentDetails implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private StockvelMainMember stockvelMainMember;
    
    @OneToMany
    private StockvelPolicy stockvelPolicy;
    
    private double amountPaid;

    
    private StockvelPaymentDetails()
    {
        
    }
    
    private StockvelPaymentDetails (Builder build){
        id = build.id;
        stockvelMainMember = build. stockvelMainMember;
        stockvelPolicy = build.stockvelPolicy;
        amountPaid = build.amountPaid;
    }
    
    public static class Builder{
        
        private Long id;
        private StockvelMainMember stockvelMainMember;
        private StockvelPolicy stockvelPolicy;
        private double amountPaid;
        
        
        public Builder()
        {
            
        }
        
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        
        public Builder stockvelMainMember(StockvelMainMember stockvelMainMember)
        {
            this.stockvelMainMember = stockvelMainMember;
            return this;
        }  
        
        public Builder stockvelPolicy(StockvelPolicy stockvelPolicy)
        {
            this.stockvelPolicy = stockvelPolicy;
            return this;
        } 
         
        public Builder amountPaid(double amountPaid)
        {
            this.amountPaid = amountPaid;
            return this;
        } 
        
       
        public Builder copy(StockvelPaymentDetails value) {
        
            this.id = value.id;
            this.stockvelMainMember = value.stockvelMainMember;
            this.stockvelPolicy = value.stockvelPolicy;
            this.amountPaid = value.amountPaid;
            return this;
        }
    
        public StockvelPaymentDetails build() {
                return new StockvelPaymentDetails(this);
        }
    } 
    
    public StockvelMainMember getStockvelMainMember() {
        return stockvelMainMember;
    }

    public StockvelPolicy getStockvelPolicy() {
        return stockvelPolicy;
    }

    public double getAmountPaid() {
        return amountPaid;
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
        if (!(object instanceof StockvelPaymentDetails)) {
            return false;
        }
        StockvelPaymentDetails other = (StockvelPaymentDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "course.domain.StockvelPaymentDetails[ id=" + id + " ]";
    }
    
}
