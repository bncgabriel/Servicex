package br.com.bncgabriel.servicex.categoria.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CATEGORIA")
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    @Column (name = "ID_CATEGORIA")
    private Integer idCategoria;

    @Column(name = "NOME_CATEGORIA")
    private String nomeCategoria;

    @OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
    private List<Service> servicos;
}
