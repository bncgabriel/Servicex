package br.com.bncgabriel.servicex.categoria.repository;

import br.com.bncgabriel.servicex.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

    Categoria save(Categoria categoria);

    List<Categoria> findAll();

    Optional<Categoria> findById(Integer idCategoria);

    void deleteById(Integer idCategoria);

}
