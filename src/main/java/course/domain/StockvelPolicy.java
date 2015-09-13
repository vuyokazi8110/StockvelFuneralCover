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

/**
 *
 * @author sbm
 */
@Entity
public class StockvelPolicy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int policyNo;
    private String policyName;
    private double premium;

   
    
    private StockvelPolicy(Builder build) 
    {
        this.id = build.id;
        this.policyNo= build.policyNo;
        this.policyName = build.policyName;
        this.premium = build.premium;
    
    }
    
    private StockvelPolicy( ) 
    {
        
    }
    
    public static class Builder
    {
        private Long id;
        private int policyNo;
        private String policyName;
        private double premium;
        
        public Builder (int policyNo)
        {
            this.policyNo=policyNo;
        }
        
        public Builder policyName(String policyName)
        {
            this.policyName = policyName;
            return this;
        }
        
        public Builder premium(double premium)
        {
            this.premium = premium;
            return this;
        }
        
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(StockvelPolicy value){
            this.id=value.id;
            this.policyNo=value.policyNo;
            this.policyName=value.policyName;
            this.premium=value.premium;
            return this;
        }
        
        public StockvelPolicy build() {
                return new StockvelPolicy(this);
            }
         
    }

    public Long getId() {
        return id;
    }
    
    public int getPolicyNo() {
        return policyNo;
    }

    public String getPolicyName() {
        return policyName;
    }
    
     public double getPremium() {
        return premium;
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
        if (!(object instanceof StockvelPolicy)) {
            return false;
        }
        StockvelPolicy other = (StockvelPolicy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "course.domain.StockvelPolicy[ id=" + id + " ]";
    }
    
}
