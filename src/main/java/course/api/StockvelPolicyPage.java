/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.api;

import course.domain.StockvelPolicy;
import course.model.StockvelPolicyResource;
import course.services.StockvelPolicyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sbm
 */
@RestController
@RequestMapping(value="/StockvelPolicy/**")
public class StockvelPolicyPage {
    @Autowired
    private StockvelPolicyService service;
    
    @RequestMapping(value="/StockvelPolicy", method=RequestMethod.GET)

    public List<StockvelPolicyResource> getPolicy() {
        List<StockvelPolicyResource> hateos = new ArrayList<>();
        List<StockvelPolicy> policies1 = service.getAllPolicy();
        for (StockvelPolicy policy : policies1) {
            
            
            StockvelPolicyResource policyResource = new StockvelPolicyResource
                    .Builder(policy.getPolicyNo())
                    .policyName(policy.getPolicyName())
                    .premium(policy.getPremium())
                    .build();
            Link policies = new
                    Link("http://localhost:8080/StockvelPolicy/"+policyResource.getId().toString())
                    .withRel("policy");
            policyResource.add(policies);
            hateos.add(policyResource);
        }
        return hateos;
    }
    
    
    
}
