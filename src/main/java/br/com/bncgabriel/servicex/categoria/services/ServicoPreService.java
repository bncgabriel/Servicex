package br.com.bncgabriel.servicex.categoria.services;

import br.com.bncgabriel.servicex.categoria.domain.ServicoP;
import br.com.bncgabriel.servicex.categoria.repository.ServicoPreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoPreService {

    @Autowired
    private ServicoPreRepository servicoPreRepository;

    public ServicoP cadastrarServicoP(ServicoP servicop) {
        return servicoPreRepository.save(servicop);
    }

    public List<ServicoP> listarServicoP() {
        return servicoPreRepository.findAll();
    }

    public Optional<ServicoP> buscarServicoP(Integer idServicoP) {
        return servicoPreRepository.findById(idServicoP);
    }

    public ServicoP atualizarServicoP(ServicoP servicop) {
        return servicoPreRepository.save(servicop);
    }

    public void deletarServicoP(Integer idServicoP) {
        servicoPreRepository.deleteById(idServicoP);
    }
}
