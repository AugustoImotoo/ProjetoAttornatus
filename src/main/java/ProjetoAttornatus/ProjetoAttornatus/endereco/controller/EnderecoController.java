package ProjetoAttornatus.ProjetoAttornatus.endereco.controller;

import ProjetoAttornatus.ProjetoAttornatus.endereco.model.Endereco;
import ProjetoAttornatus.ProjetoAttornatus.endereco.repository.EnderecoRepository;
import ProjetoAttornatus.ProjetoAttornatus.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;

    //Buscar todos os endereços
    @GetMapping("/buscarEnderecos")
    public List<Endereco> buscarEndereco(){
        return enderecoService.buscarTodosEnderecos();
    }
    //Buscar endereço por ID
    @GetMapping("/buscarEnderecos/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable("id") Integer id) {
        Optional<Endereco> enderecoRegistro = enderecoRepository.findById(id);

        if (enderecoRegistro.isPresent()) {
            return new ResponseEntity<>(enderecoRegistro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Criando endereço.
    @PostMapping("/endereco")
    public ResponseEntity<Endereco> criarEndereco (@RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(endereco);
    }

}
