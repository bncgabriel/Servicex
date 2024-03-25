package br.com.bncgabriel.servicex.categoria.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SERVICOS")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICOS")
    private Integer idService;

    @Column(name = "NOME_SERVICOS")
    private String nomeService;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categorias;

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNomeService() {
        return nomeService;
    }

    public void setNomeService(String nomeService) {
        this.nomeService = nomeService;
    }
}