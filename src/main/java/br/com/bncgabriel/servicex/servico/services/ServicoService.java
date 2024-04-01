package br.com.bncgabriel.servicex.servico.services;

import br.com.bncgabriel.servicex.servico.domain.Servico;
import br.com.bncgabriel.servicex.servico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico cadastrarServico(Servico servicop) {
        return servicoRepository.save(servicop);
    }

    public List<Servico> listarServico() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarServico(Integer idServico) {
        return servicoRepository.findById(idServico);
    }

    public Servico atualizarServico(Servico servicop) {
        return servicoRepository.save(servicop);
    }

    public void deletarServico(Integer idServico) {
        servicoRepository.deleteById(idServico);
    }
}
