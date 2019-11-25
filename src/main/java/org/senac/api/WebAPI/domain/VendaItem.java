package org.senac.api.WebAPI.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
*
* @author Christian
*/

@Entity
@Table(name="tb_venda_item")
public class VendaItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_venda_item")
    private Integer idVendaItem;
    
	@NotNull
    private Integer quantidade;
	
	@NotNull
    private Double valorUnitario;
    
	@ManyToOne
	@JoinColumn(name="id_produto")
	@NotNull    
    private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="id_venda")
	@NotNull
	@JsonIgnore
    private Venda venda;

	public Integer getIdVendaItem() {
		return idVendaItem;
	}

	public void setIdVendaItem(Integer idVendaItem) {
		this.idVendaItem = idVendaItem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}	

		
}
