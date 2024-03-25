package br.com.bncgabriel.servicex.categoria.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table (name = "SERVICOS_PRESTADOS")
public class ServicoP {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVICO_P")
    private Integer idServicoP;

    @Column (name = "NOME_SERVICO_P")
    private String nomeServicoP;

    @Column(name = "VALOR_SERVICO_P")
    private Double valorServicoP;

}
