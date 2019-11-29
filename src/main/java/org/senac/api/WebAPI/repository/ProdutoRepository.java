package org.senac.api.WebAPI.repository;

import java.time.LocalDate;
import java.util.List;

import org.senac.api.WebAPI.domain.Produto;
import org.senac.api.WebAPI.vo.ProdutoVendido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
*
* @author Christian
*/

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
	@Query("select new org.senac.api.WebAPI.vo.ProdutoVendido(p.descricao, p.idProduto, sum(i.quantidade), sum(i.valorUnitario)) "
			+ " from Venda v "
			+ " inner join v.itens i "
			+ " inner join i.produto p "
			+ " where v.confirmada = true "
			+ " group by p.descricao, p.idProduto"
			+ " order by 3 desc")
	List<ProdutoVendido> findTotalProdutoVendido();	
	
	@Query("select new org.senac.api.WebAPI.vo.ProdutoVendido(p.descricao, p.idProduto, sum(i.quantidade), sum(i.valorUnitario)) "
			+ " from Venda v "
			+ " inner join v.itens i "
			+ " inner join i.produto p "
			+ " where v.confirmada = true "
			+ "   and v.dataVenda = ?1"
			+ " group by p.descricao, p.idProduto"
			+ " order by 3 desc")
	List<ProdutoVendido> findTotalProdutoVendidoByDataVenda(LocalDate venda);		
	
}
