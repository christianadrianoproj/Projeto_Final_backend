package org.senac.api.WebAPI.vo;

/**
*
* @author Christian
*/

public class ProdutoVendido {
	
	private String descricaoProduto;
	private Integer idProduto;
	private Long quantidadeVendido;
	private Double totalProduto;
	
	public ProdutoVendido(String descricaoProduto, Integer idProduto, Long quantidadeVendido, Double totalProduto) {
		super();
		this.descricaoProduto = descricaoProduto;
		this.idProduto = idProduto;
		this.quantidadeVendido = quantidadeVendido;
		this.totalProduto = totalProduto;
	}
	
	public Double getTotalVendido() {
		return getTotalProduto() * getQuantidadeVendido();
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Long getQuantidadeVendido() {
		return quantidadeVendido;
	}

	public void setQuantidadeVendido(Long quantidadeVendido) {
		this.quantidadeVendido = quantidadeVendido;
	}

	public Double getTotalProduto() {
		return totalProduto;
	}

	public void setTotalProduto(Double totalProduto) {
		this.totalProduto = totalProduto;
	}	
}
