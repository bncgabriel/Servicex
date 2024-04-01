package br.com.bncgabriel.servicex.servico.repository;

import br.com.bncgabriel.servicex.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Integer> {
}
