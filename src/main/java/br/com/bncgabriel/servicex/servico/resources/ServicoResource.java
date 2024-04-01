package br.com.bncgabriel.servicex.servico.resources;

import br.com.bncgabriel.servicex.servico.services.ServicoService;
import br.com.bncgabriel.servicex.servico.domain.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> cadastrarServico(@RequestBody Servico novoServico) {
        Servico servicoCriado = servicoService.cadastrarServico(novoServico);
        return new ResponseEntity<>(servicoCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarServico() {
        List<Servico> servicos = servicoService.listarServico();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{idServico}")
    public ResponseEntity<Servico> buscarServico(@PathVariable Integer idServico) {
        return servicoService.buscarServico(idServico)
                .map(servicoP -> new ResponseEntity<>(servicoP, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<Void> deletarServico(@PathVariable Integer idServico) {
        servicoService.deletarServico(idServico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idServico}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Integer idServico, @RequestBody Servico servico) {
        if (!servicoService.buscarServico(idServico).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.setIdServico(idServico);
        Servico novoServico = servicoService.atualizarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.OK);
    }

}