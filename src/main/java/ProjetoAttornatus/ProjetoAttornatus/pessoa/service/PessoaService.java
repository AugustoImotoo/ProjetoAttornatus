package ProjetoAttornatus.ProjetoAttornatus.pessoa.service;


import ProjetoAttornatus.ProjetoAttornatus.pessoa.model.Pessoa;
import ProjetoAttornatus.ProjetoAttornatus.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Localizar todos os registros
    public List<Pessoa> buscarTodasPessoas() {
        List<Pessoa> listPessoa = pessoaRepository.findAll();
        return listPessoa;
    }

    public ResponseEntity<Pessoa> criarPessoa (Pessoa pessoa) {
        // Criar registro
        try {
            Pessoa novaPessoa  = pessoaRepository
                    .save(new Pessoa(pessoa.getNome(), pessoa.getDataNascimento() ,pessoa.getEndereco(), pessoa.getEnderecoPrincipal()));
            return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Excluir registro
    public ResponseEntity <?> deletarPessoa(@PathVariable Integer id) {
        return pessoaRepository.findById(id)
                .map(record -> {
                    pessoaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    //Atualizar registro
    public Optional<ResponseEntity<Pessoa>> atualizarPessoa(Integer id, @RequestBody Pessoa pessoa) {
        return pessoaRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(pessoa.getNome());
                    recordFound.setDataNascimento(pessoa.getDataNascimento());
                    recordFound.setEndereco(pessoa.getEndereco());
                    recordFound.setEnderecoPrincipal(pessoa.getEnderecoPrincipal());
                    Pessoa updated = pessoaRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                });
    }

}
