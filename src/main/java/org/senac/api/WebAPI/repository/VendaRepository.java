package org.senac.api.WebAPI.repository;

import java.util.List;

import org.senac.api.WebAPI.domain.Venda;
import org.senac.api.WebAPI.vo.TotalVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
*
* @author Christian
*/

public interface VendaRepository extends JpaRepository<Venda, Integer>{
	
	@Query("select new org.senac.api.WebAPI.vo.TotalVenda(v.dataVenda, count(v.dataVenda)) "
			+ " from Venda v "
			+ " where v.confirmada = true "
			+ " group by v.dataVenda"
			+ " order by 1 desc")
	List<TotalVenda> findVendasByData();	

}
