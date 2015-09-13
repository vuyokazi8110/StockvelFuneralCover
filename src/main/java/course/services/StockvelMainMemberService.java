/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.services;

import course.domain.StockvelMainMember;
import course.domain.StockvelSubmember;
import java.util.List;

/**
 *
 * @author sbm
 */
public interface StockvelMainMemberService {
     List<StockvelMainMember> getAllSubmembers();
     List<StockvelSubmember> getSubmember(Long id);
    
}
