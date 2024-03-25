package br.com.bncgabriel.servicex.categoria.repository;

import br.com.bncgabriel.servicex.categoria.domain.ServicoP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPreRepository extends JpaRepository<ServicoP,Integer> {
}
