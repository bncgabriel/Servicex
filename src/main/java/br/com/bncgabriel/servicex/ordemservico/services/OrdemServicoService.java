package br.com.bncgabriel.servicex.ordemservico.services;

import br.com.bncgabriel.servicex.ordemservico.domain.OrdemServico;
import br.com.bncgabriel.servicex.ordemservico.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criarOS(OrdemServico novaOS) {
        return ordemServicoRepository.save(novaOS);
    }

    public List<OrdemServico> listarOS() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarOS(Integer idOS) {
        return ordemServicoRepository.findById(idOS);
    }

    public void deletarOS(Integer idOS) {
        ordemServicoRepository.deleteById(idOS);
    }

    public OrdemServico atualizarOS(Integer idOS,OrdemServico ordemServico) {
        Optional<OrdemServico> ordemServicoEncontrada = buscarOS(idOS);
        if (ordemServicoEncontrada.isPresent()) {

            OrdemServico ordemServicoAtualizada = ordemServicoEncontrada.get();
            ordemServicoAtualizada.setDataSolicitacao(ordemServico.getDataSolicitacao());
            ordemServicoAtualizada.setValorOS(ordemServico.getValorOS());

            return ordemServicoRepository.save(ordemServicoAtualizada);
        } else {
            return null;
        }
    }

    public void setIdOS(Integer idOS) {
    }
}
