package org.senac.api.WebAPI.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
*
* @author Christian
*/

@Entity
@Table(name="tb_venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_venda")
    private Integer idVenda;
    
	@NotNull
    private LocalDate dataVenda;
	
	@NotNull
    private Boolean confirmada;	
    
	@ManyToOne
	@JoinColumn(name="id_cliente")
    private Cliente cliente;

    private Double desconto;
    
    private Double valorPago;

    @OneToMany(mappedBy = "venda")
    /*@Cascade({ org.hibernate.annotations.CascadeType.ALL })*/
    private List<VendaItem> itens;

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public List<VendaItem> getItens() {
		return itens;
	}

	public void setItens(List<VendaItem> itens) {
		this.itens = itens;
	}
	
	
    public Boolean getConfirmada() {
		return confirmada;
	}

	public void setConfirmada(Boolean confirmada) {
		this.confirmada = confirmada;
	}

	public Double getValorTroco() {
        if (getValorPago() > getTotalVendaLiquida()) {
            return getValorPago() - getTotalVendaLiquida();
        } else {
            return 0.0d;
        }
    }
    
    public Double getTotalVenda() {
    	Double total = 0.0d;
        for (VendaItem i : itens) {
            total += (i.getValorUnitario() * i.getQuantidade());
        }
        return total;
    }    
    
    public Double getTotalVendaLiquida() {
    	Double total = this.getTotalVenda();
        total = total - this.getDesconto();
        return total;
    }    
    
}
