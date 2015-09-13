/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.api.integrationtests;

import course.App;
import course.api.StockvelPolicyPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author sbm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class StockVelPolicyPageTest 
{
        final String BASE_URL = "http://localhost:8080/";
    private MockMvc mockMvc;

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(new StockvelPolicyPage())
                .build();
    }

    @Test
    public void read() throws Exception {

        //private int policyNo;
   // private String policyName;
   // private double premium;
        mockMvc
                .perform(get(BASE_URL+"api/test/read/{id}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"policy_no\":\"1234\",\"policyName\":Death Insurance\",\"premium\":700\"}"));
    }

    @Test
    public void readAll() throws Exception {

        mockMvc
                .perform(get(BASE_URL+"api/test/readall"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content().string(
                                "{\"stockvelpolicies\":[{\"policy_no\":\"1234\",\"policyName\":Death Insurance\",\"premium\":700\"}"
                                        ));
    }

    @Test
    public void create() throws Exception {

        mockMvc
                .perform(
                        post(BASE_URL+"api/test/create").contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content("{\"policy_no\":\"1234\",\"policyName\":Death Insurance\",\"premium\":700\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content().string("{\"policy_no\":\"1234\",\"policyName\":Death Insurance\",\"premium\":700\"}"));
    }

    @Test
    public void update() throws Exception {

        mockMvc
                .perform(
                        put(BASE_URL+"api/test/update").contentType(MediaType.APPLICATION_JSON).content(
                                "{\"policy_no\":\"1234\",\"policyName\":Death Insurance\",\"premium\":1000\"}")).andExpect(
                status().isOk());
    }

    @Test
    public void remove() throws Exception {

        mockMvc
                .perform(
                        delete(BASE_URL+"api/test/delete").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
