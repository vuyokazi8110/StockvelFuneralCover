/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.repository;

import course.domain.StockvelSubmember;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sbm
 */
public interface StockvelSubmemberRepository extends CrudRepository<StockvelSubmember,Long>{
    
}
