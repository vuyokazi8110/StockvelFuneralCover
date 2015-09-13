/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.services.Impl;

import course.domain.StockvelPolicy;
import course.repository.StockvelPolicyRepository;
import course.services.StockvelPolicyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sbm
 */
@Service
public class StockvelPolicyServiceImpl implements StockvelPolicyService{

    
    @Autowired
    StockvelPolicyRepository repository;
    
    @Override
    public List<StockvelPolicy> getAllPolicy() {
        
         List<StockvelPolicy> allPolicy = new ArrayList<>();

        Iterable<StockvelPolicy> Policies = repository.findAll();
        for (StockvelPolicy policy : Policies) {
            allPolicy.add(policy);
        }
        return allPolicy;
    }
    
}
