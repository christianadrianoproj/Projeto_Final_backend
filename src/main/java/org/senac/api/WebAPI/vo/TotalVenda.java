package org.senac.api.WebAPI.vo;

import java.time.LocalDate;

/**
*
* @author Christian
*/

public class TotalVenda {
	
	private LocalDate dataVenda;
	
	private Long quantidade;
	
	public TotalVenda(LocalDate dataVenda, Long quantidade) {
		super();
		this.dataVenda = dataVenda;
		this.quantidade = quantidade;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}	
}
