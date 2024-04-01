package br.com.bncgabriel.servicex.pagamento.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@JsonTypeName("pagamentoCartao")
public class PagamentoCartao extends Pagamento{

    @Column(name = "DATA_VENCIMENTO_CC")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimentoCc;

    @Column(name = "CVV")
    private int cvv;

    @Column(name = "TITULAR")
    private String titular;

}
