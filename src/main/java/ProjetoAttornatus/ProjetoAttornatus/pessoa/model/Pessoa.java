package ProjetoAttornatus.ProjetoAttornatus.pessoa.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="pessoa_seq", sequenceName="pessoa_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_seq")
    private long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA_NASC")
    private Date dataNascimento;
    @Column(name = "ENDERECO")
    private Integer endereco;
    @Column(name = "ENDERECO_PRINCIPAL")
    private Boolean enderecoPrincipal;

    public Pessoa(String nome, Date dataNascimento, Integer endereco, Boolean enderecoPrincipal) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.enderecoPrincipal = enderecoPrincipal;
    }



    public Pessoa() {

    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEndereco() {
        return endereco;
    }

    public void setEndereco(Integer endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
}
