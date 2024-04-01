package br.com.bncgabriel.servicex.servico.domain;

import br.com.bncgabriel.servicex.categoria.domain.Categoria;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table (name = "SERVICOS")
public class Servico {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVICO")
    private Integer idServico;

    @Column (name = "NOME_SERVICO")
    private String nomeServico;

    @Column(name = "VALOR_SERVICO")
    private Double valorServico;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categorias;
}
