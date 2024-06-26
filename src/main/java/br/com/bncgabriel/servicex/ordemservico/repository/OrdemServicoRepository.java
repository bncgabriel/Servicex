package br.com.bncgabriel.servicex.ordemservico.repository;

import br.com.bncgabriel.servicex.ordemservico.domain.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
}
