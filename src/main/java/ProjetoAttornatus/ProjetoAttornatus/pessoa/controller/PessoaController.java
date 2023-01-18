package ProjetoAttornatus.ProjetoAttornatus.pessoa.controller;

import ProjetoAttornatus.ProjetoAttornatus.pessoa.model.Pessoa;
import ProjetoAttornatus.ProjetoAttornatus.pessoa.repository.PessoaRepository;
import ProjetoAttornatus.ProjetoAttornatus.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;
    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> criarPessoa (@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }
    @DeleteMapping("/pessoa/{id}")
    public Optional<Object> deletarPessoa (@PathVariable Integer id) {
        return Optional.ofNullable(pessoaService.deletarPessoa(id));
    }
    @PutMapping("/pessoa/{id}")
    public Optional<ResponseEntity<Pessoa>> atualizarPessoa (@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }
    @GetMapping("/buscarpessoas/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable("id") Integer id) {
        Optional<Pessoa> pessoaRegistro = pessoaRepository.findById(id);

        if (pessoaRegistro.isPresent()) {
            return new ResponseEntity<>(pessoaRegistro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/buscarPessoas")
    public List<Pessoa> buscarUsuario(){
        return pessoaService.buscarTodasPessoas();
    }
}
