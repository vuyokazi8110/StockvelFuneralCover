/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.services.Impl;

import course.domain.StockvelMainMember;
import course.domain.StockvelSubmember;
import course.repository.StockvelMainMemberRepository;
import course.services.StockvelMainMemberService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sbm
 */
@Service
public class StockvelMainMemberServiceImpl implements StockvelMainMemberService{
    
    @Autowired
    private StockvelMainMemberRepository repository;

   @Override
    public List<StockvelMainMember> getAllSubmembers() {
        
        List<StockvelMainMember> stockvelMainMember = new ArrayList<>();
        Iterable<StockvelMainMember> values = repository.findAll();
        for (StockvelMainMember value : values) {
            stockvelMainMember.add(value);
        }
        return stockvelMainMember;
        
        }
    
    @Override
    public List<StockvelSubmember> getSubmember(Long id) {
        
      return repository.findOne(id).getStockvelSubmember();
                
    }
    
}
