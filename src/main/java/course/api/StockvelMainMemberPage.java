/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.api;

import course.domain.StockvelMainMember;
import course.domain.StockvelSubmember;
import course.model.StockvelMainMemberResource;
import course.services.StockvelMainMemberService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sbm
 */
@RestController
@RequestMapping(value="/MainMember/**")
public class StockvelMainMemberPage {
    
    @Autowired
    private StockvelMainMemberService service;
    
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<StockvelSubmember> getFacultyDepartments(@PathVariable Long id) {


        return service.getSubmember(id);
    }

    @RequestMapping(value="/MainMembers", method=RequestMethod.GET)

    public List<StockvelMainMemberResource> getAllMembers() {
        List<StockvelMainMemberResource> hateos = new ArrayList<>();
        List<StockvelMainMember> main = service.getAllSubmembers();
        for (StockvelMainMember member : main) {
            
            StockvelMainMemberResource mainMemberResource = new StockvelMainMemberResource
                    .Builder()
                    .stokvelFullname(member.getStokvelFullname())
                    .stockvelAddress(member.getStockvelAddress())
                    .stockvelContact(member.getStockvelContact())
                    .stockvelSubmember(member.getStockvelSubmember())
                    .build();
            Link submember = new
                    Link("http://localhost:8080/MainMember/"+mainMemberResource.getId().toString())
                    .withRel("Member");
            mainMemberResource.add(submember);
            hateos.add(mainMemberResource);
        }
        return hateos;
    }
//
    
}
