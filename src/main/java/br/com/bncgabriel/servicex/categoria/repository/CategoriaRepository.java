package br.com.bncgabriel.servicex.categoria.repository;

import br.com.bncgabriel.servicex.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

}
