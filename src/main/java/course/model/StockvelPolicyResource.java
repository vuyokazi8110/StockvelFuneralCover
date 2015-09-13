/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.model;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author sbm
 */
public class StockvelPolicyResource extends ResourceSupport{
    
    
    private int policyNo;
    private String policyName;
    private double premium;

   
    
    private StockvelPolicyResource(Builder build) 
    {
        this.policyNo= build.policyNo;
        this.policyName = build.policyName;
        this.premium = build.premium;
    
    }
    
    private StockvelPolicyResource( ) 
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
       

        public Builder copy(StockvelPolicyResource value){
            this.policyNo=value.policyNo;
            this.policyName=value.policyName;
            this.premium=value.premium;
            return this;
        }
        
        public StockvelPolicyResource build() {
                return new StockvelPolicyResource(this);
            }
         
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
    
}
