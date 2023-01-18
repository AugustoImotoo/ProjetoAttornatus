package ProjetoAttornatus.ProjetoAttornatus.endereco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="endereco_seq", sequenceName="endereco_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="endereco_seq")
    private long id;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "CIDADE")
    private String cidade;

    public Endereco(String logradouro, String cep, Integer numero, String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Endereco() {

    }

    public long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
