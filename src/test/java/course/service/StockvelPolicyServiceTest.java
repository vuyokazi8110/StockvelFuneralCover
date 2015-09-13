/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.service;

import course.App;
import course.conf.factory.StockvelPolicyFactory;
import course.domain.StockvelPolicy;
import course.repository.StockvelPolicyRepository;
import course.services.StockvelPolicyService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author sbm
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelPolicyServiceTest extends AbstractTestNGSpringContextTests{
    
    @Autowired
    private StockvelPolicyService service;

    private Long id;

    @Autowired
    private StockvelPolicyRepository repository;
    private List<StockvelPolicy> stockvelPolicy;
    @BeforeMethod
    public void setUp() throws Exception {
        stockvelPolicy = new ArrayList<>();

    }
    @Test
    public void create() throws Exception {

        
        StockvelPolicy policy1 = StockvelPolicyFactory
                .createPolicy(123345, "Stockvel Life Cover", 580.00);
        
        StockvelPolicy policy2 = StockvelPolicyFactory
                .createPolicy(12678, "Stockvel Saver", 320.00);

        StockvelPolicy policy = StockvelPolicyFactory
                .createPolicy(123345, "Stockvel Life Cover", 580.00);

        stockvelPolicy.add(policy1);
        stockvelPolicy.add(policy1);


        repository.save(stockvelPolicy);
        id=policy.getId();
        Assert.assertNotNull(policy.getId());
    }


    @Test
    public void testGetFacultyDepartmets() throws Exception {
        List<StockvelPolicy> stockvelPolicies = service.getAllPolicy();
        Assert.assertTrue(stockvelPolicies.size() == 1);
    }
}
