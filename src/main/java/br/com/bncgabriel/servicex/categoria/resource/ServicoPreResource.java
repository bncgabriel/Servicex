package br.com.bncgabriel.servicex.categoria.resource;

import br.com.bncgabriel.servicex.categoria.domain.ServicoP;
import br.com.bncgabriel.servicex.categoria.services.ServicoPreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ServicoPreResource {

    @Autowired
    private ServicoPreService servicoPreService;

    @PostMapping
    public ResponseEntity<ServicoP> cadastrarServicoP(@RequestBody ServicoP novoServicoP) {
        ServicoP servicoPCriado = servicoPreService.cadastrarServicoP(novoServicoP);
        return new ResponseEntity<>(servicoPCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServicoP>> listarServicoP() {
        List<ServicoP> servicos = servicoPreService.listarServicoP();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{idServicoP}")
    public ResponseEntity<ServicoP> buscarServicoP(@PathVariable Integer idServicoP) {
        return servicoPreService.buscarServicoP(idServicoP)
                .map(servicoP -> new ResponseEntity<>(servicoP, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idServicoP}")
    public ResponseEntity<Void> deletarServico(@PathVariable Integer idServicoP) {
        servicoPreService.deletarServicoP(idServicoP);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idServicoP}")
    public ResponseEntity<ServicoP> atualizarServico(@PathVariable Integer idServicoP, @RequestBody ServicoP servico) {
        if (!servicoPreService.buscarServicoP(idServicoP).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.setIdServicoP(idServicoP);
        ServicoP novoServicoP = servicoPreService.atualizarServicoP(servico);
        return new ResponseEntity<>(novoServicoP, HttpStatus.OK);
    }

}