package br.com.bncgabriel.servicex.pagamento.domain;

import br.com.bncgabriel.servicex.ordemservico.domain.OrdemServico;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PAGAMENTO")
@NoArgsConstructor
public class Pagamento {

    @Id
    private Integer idPagamento;

    @Column(name = "STATUS_PAGAMENTO")
    private Integer statusPagamento;

    @OneToOne
    @JoinColumn(name = "ID_OS")
    private OrdemServico ordemServico;

    public Pagamento(Integer idPagamento, Integer statusPagamento, OrdemServico ordemServico) {
        this.idPagamento = idPagamento;
        this.statusPagamento = statusPagamento;
        this.ordemServico = ordemServico;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(Integer statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
}
