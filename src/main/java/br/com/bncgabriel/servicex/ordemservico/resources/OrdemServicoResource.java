package br.com.bncgabriel.servicex.ordemservico.resources;


import br.com.bncgabriel.servicex.ordemservico.domain.OrdemServico;
import br.com.bncgabriel.servicex.ordemservico.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> cadastrarOS(@RequestBody OrdemServico novaOS) {
        OrdemServico ordemServicoCriada = ordemServicoService.criarOS(novaOS);
        return new ResponseEntity<>(ordemServicoCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarOS() {
        List<OrdemServico> ordensServico = ordemServicoService.listarOS();
        return ResponseEntity.ok(ordensServico);
    }

    @GetMapping("/{idOS}")
    public ResponseEntity<OrdemServico> buscarOS(@PathVariable Integer idOS) {
        Optional<OrdemServico> ordemServicoEncontrada = ordemServicoService.buscarOS(idOS);
        return ordemServicoEncontrada
                .map(ordemServico -> new ResponseEntity<>(ordemServico, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idOS}")
    public ResponseEntity<Void> deletarOS(@PathVariable Integer idOS) {
        ordemServicoService.deletarOS(idOS);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idOS}")
    public ResponseEntity<OrdemServico> atualizarOS(@PathVariable Integer idOS, @RequestBody OrdemServico ordemServico) {
        Optional<OrdemServico> ordemServicoEncontrada = ordemServicoService.buscarOS(idOS);
        if (!ordemServicoEncontrada.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OrdemServico ordemServicoAtualizada = ordemServicoEncontrada.get();
        ordemServicoAtualizada.setDataSolicitacao(ordemServico.getDataSolicitacao());
        ordemServicoAtualizada.setValorOS(ordemServico.getValorOS());

        OrdemServico novaOS = ordemServicoService.atualizarOS(idOS, ordemServicoAtualizada);
        return new ResponseEntity<>(novaOS, HttpStatus.OK);
    }
}
