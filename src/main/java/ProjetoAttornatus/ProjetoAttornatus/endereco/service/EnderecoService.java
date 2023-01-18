package ProjetoAttornatus.ProjetoAttornatus.endereco.service;


import ProjetoAttornatus.ProjetoAttornatus.endereco.model.Endereco;
import ProjetoAttornatus.ProjetoAttornatus.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    //Localizar Endereço
    public List<Endereco> buscarTodosEnderecos() {
        List<Endereco> listEndereco = enderecoRepository.findAll();
        return listEndereco;
    }

    public ResponseEntity<Endereco> criarEndereco (Endereco endereco) {
        // Criação do Endereço
        try {
            Endereco novoEndereco  = enderecoRepository
                    .save(new Endereco(endereco.getLogradouro(), endereco.getCep() ,endereco.getNumero(), endereco.getCidade()));
            return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
