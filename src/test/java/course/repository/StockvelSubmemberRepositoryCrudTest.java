/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.App;
import course.conf.factory.StockvelSubmemberFactory;
import course.domain.StockvelAddress;
import course.domain.StockvelContact;
import course.domain.StockvelDemographic;
import course.domain.StockvelFullname;
import course.domain.StockvelSubmember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StockvelSubmemberRepositoryCrudTest extends AbstractTestNGSpringContextTests{
    
     private Long id;

    @Autowired
    private StockvelSubmemberRepository repository;

   @Test
    public void create() throws Exception {
        
        StockvelFullname stokvelFullname = new StockvelFullname
                .Builder("Richard")
                .lastName("Graemes")
                .build();
        
        StockvelDemographic stockvelDemographic = new StockvelDemographic.Builder("9201275885071")
                .Gender("Male")
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
          
       StockvelSubmember submember = StockvelSubmemberFactory
                .createSubmember(stokvelFullname, 
                        stockvelDemographic, 
                        stockvelAddress, 
                        stockvelContact,true);
        
        repository.save(submember);
        id = submember.getId();
        
        Assert.assertNotNull(submember);
    }

   @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        
        StockvelSubmember submember = repository.findOne(id);
        Assert.assertNotNull(submember.getId());
        
        
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StockvelSubmember submember = repository.findOne(id);

        StockvelSubmember newSubmember = new StockvelSubmember
                .Builder()
                .stokvelFullname(submember.getStokvelFullname())
                .stockvelDemographic(submember.getStockvelDemographic())
                .stockvelAddress(submember.getStockvelAddress())
                .stockvelContact(submember.getStockvelContact())
                .copy(submember)
                .isBeneficiary(false)
                .build();

        repository.save(newSubmember);

        StockvelSubmember updatedSubmember = repository.findOne(id);
        Assert.assertFalse(updatedSubmember.isBeneficiary());

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StockvelSubmember submember = repository.findOne(id);
        repository.delete(submember);
        StockvelSubmember deletedSubmember = repository.findOne(id);
        Assert.assertNull(deletedSubmember);

    }
}
