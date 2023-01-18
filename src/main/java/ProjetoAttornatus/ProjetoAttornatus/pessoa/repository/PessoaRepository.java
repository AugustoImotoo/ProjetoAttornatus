package ProjetoAttornatus.ProjetoAttornatus.pessoa.repository;

import ProjetoAttornatus.ProjetoAttornatus.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

}
