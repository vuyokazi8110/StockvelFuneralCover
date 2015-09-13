/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.App;
import course.conf.factory.StockvelMainMemberFactory;
import course.domain.StockvelAddress;
import course.domain.StockvelClaim;
import course.domain.StockvelContact;
import course.domain.StockvelDemographic;
import course.domain.StockvelFullname;
import course.domain.StockvelMainMember;
import course.domain.StockvelPolicy;
import course.domain.StockvelSubmember;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author sbm
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelMainMemberRepositoryCrudTest {
    
   private Long id;

    @Autowired
    private StockvelMainMemberRepository repository;

   @Test
    public void create() throws Exception {
        
        //Stockvel MainMember
        StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Vuyo")
                .lastName("Wando")
                .build();
        
        StockvelDemographic stockvelDemographic = new StockvelDemographic
                .Builder("8505260089081")
                .Gender("Female")
                .race("Other")
                .build();
        
        StockvelAddress stockvelAddress = new StockvelAddress
                .Builder()
                .streetNo("12b")
                .streetName("Sheet Street")
                .suburb("belhar")
                .postalCode("6290")
                .build();
        
        StockvelContact stockvelContact = new StockvelContact.
                Builder("VuyoW@gmail.com")
                .HomeNumber("0210001111")
                .CellNumber("0780001111")
                .build();
        
        //Stockvel Submember1
        StockvelFullname stokvelFullnameSub1 = new StockvelFullname
                .Builder("Thando")
                .lastName("Zuma")
                .build();
        
         StockvelDemographic stockvelDemographicSub1 = new StockvelDemographic
                .Builder("970803897801")
                .Gender("Male")
                .race("Other")
                .build();
        
         StockvelAddress stockvelAddressSub1 = new StockvelAddress
                .Builder()
                .streetNo("14")
                .streetName("Jam Street")
                .suburb("Kwetu")
                .postalCode("6789")
                .build();
         
         StockvelContact stockvelContactSub1 = new StockvelContact.
                Builder("Thando@gmail.com")
                 .HomeNumber("0211110000")
                .CellNumber("0799990000")
                .build();
         
         StockvelSubmember stockvelSubmember1 = new StockvelSubmember.Builder()
                .stokvelFullname(stokvelFullnameSub1)
                .stockvelAddress(stockvelAddressSub1)
                .stockvelContact(stockvelContactSub1)
                .stockvelDemographic(stockvelDemographicSub1)
                .isBeneficiary(true)
                .build();
        
         
        //Stockvel Submember2
        StockvelFullname stokvelFullnamesub2 = new StockvelFullname
                .Builder("Trevor")
                .lastName("Noels")
                .build();
        
        StockvelDemographic stockvelDemographicSub2 = new StockvelDemographic
                .Builder("9501295778909")
                .Gender("Male")
                .race("Other")
                .build();
        
         StockvelAddress stockvelAddressSub2 = new StockvelAddress
                .Builder()
                .streetNo("17")
                .streetName("Pine Street")
                .suburb("Jessica Park")
                .postalCode("8900")
                .build();
         
         StockvelContact stockvelContactSub2 = new StockvelContact.
                Builder("Trevor@gmail.com")
                 .HomeNumber("0212220000")
                .CellNumber("0792220000")
                .build();
        
        StockvelSubmember stockvelSubmember2 = new StockvelSubmember.Builder()
                .stokvelFullname(stokvelFullnamesub2)
                .stockvelDemographic(stockvelDemographicSub2)
                .stockvelContact(stockvelContactSub2)
                .stockvelAddress(stockvelAddressSub2)
                .isBeneficiary(false)
                .build();
        
        List<StockvelSubmember>stockvelSubmember = new ArrayList<>();
        stockvelSubmember.add(stockvelSubmember1);
        stockvelSubmember.add(stockvelSubmember2);
        
        
        
        //Main Member Policy1
        StockvelPolicy policy1 = new StockvelPolicy.Builder(001)
                .policyName("Stockvel saver")
                .premium(250.00)
                .build();
        
        StockvelPolicy policy2 = new StockvelPolicy.Builder(002)
                .policyName("Stockvel Death")
                .premium(300.00)
                .build();
        
        List<StockvelPolicy> stockvelPolicy = new ArrayList<>();
        stockvelPolicy.add(policy1);
        stockvelPolicy.add(policy2);
        
        StockvelClaim claim1 = new StockvelClaim.Builder("STV001")
                .stockvelPolicy(policy1)
                .build();
        
        StockvelClaim claim2 = new StockvelClaim.Builder("STV001")
                .stockvelPolicy(policy2)
                .build();
                
        List<StockvelClaim> stockvelClaim = new ArrayList<>();
        stockvelClaim.add(claim1);
        stockvelClaim.add(claim2);
                
        StockvelMainMember mainMember = StockvelMainMemberFactory
                .createMainMember(stokvelFullname, 
                        stockvelDemographic, 
                        stockvelAddress, 
                        stockvelContact, 
                        stockvelSubmember, 
                        stockvelPolicy,
                        stockvelClaim);
        
        repository.save(mainMember);
        id=mainMember.getId();
        
        Assert.assertNotNull(mainMember);
        
        
        
    }

   @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelMainMember mainMember = repository.findOne(id);
        Assert.assertNotNull(mainMember.getId());
        
        Assert.assertEquals("Vuyo",mainMember.getStokvelFullname().getFirstName());
        Assert.assertEquals("Wando",mainMember.getStokvelFullname().getLastName());
        Assert.assertEquals("8505260089081",mainMember.getStockvelDemographic().getIdNumber());
        Assert.assertEquals("Other",mainMember.getStockvelDemographic().getRace());
        Assert.assertEquals("Female",mainMember.getStockvelDemographic().getGender());
        Assert.assertEquals("13",mainMember.getStockvelAddress().getStreetNo());
        Assert.assertEquals("Sheet Street",mainMember.getStockvelAddress().getStreetName());
        Assert.assertEquals("belhar",mainMember.getStockvelAddress().getSuburb());
        Assert.assertEquals("6290",mainMember.getStockvelAddress().getPostalCode());
        Assert.assertEquals("VuyoW@gmail.com",mainMember.getStockvelContact().getEmail());
        Assert.assertEquals("0210001111",mainMember.getStockvelContact().getHomeNumber());
        Assert.assertEquals("0780001111",mainMember.getStockvelContact().getCellNumber());
        
        
    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelMainMember mainMember = repository.findOne(id);

        StockvelMainMember newMainMember = new StockvelMainMember
                .Builder()
                .stokvelFullname(mainMember.getStokvelFullname())
                .stockvelSubmember(mainMember.getStockvelSubmember())
                .stockvelAddress(mainMember.getStockvelAddress())
                .stockvelClaim(mainMember.getStockvelClaim())
                .stockvelContact(mainMember.getStockvelContact())
                .stockvelDemographic(mainMember.getStockvelDemographic())
                .stockvelPolicy(mainMember.getStockvelPolicy())
                .copy(mainMember)
                .build();

        repository.save(newMainMember);

        StockvelMainMember updateMainMember = repository.findOne(id);
        Assert.assertEquals("Vuyo",updateMainMember.getStokvelFullname().getFirstName());

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
         StockvelMainMember mainMember = repository.findOne(id);
        repository.delete(mainMember);
        StockvelMainMember deletedMainMember = repository.findOne(id);
        Assert.assertNull(deletedMainMember);

    }
}