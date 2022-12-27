package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puxador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 15)
    private String cpf;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false, length = 20)
    private String codinome;

    @Column(nullable = false, length = 30)
    private String senha;

    @Column(length = 15)
    private String telefone;

    @Column(length = 200)
    private String endereco;

    @Column(name = "ENDERECO_MAE", length = 200)
    private String enderecoMae;

    @Column(name = "QUANTIDADE_PRISOES")
    private Integer quantidadePrisoes;

    @Column(name = "ESPECIALIDADE_ROUBO", length = 75)
    private String especialidadeRoubo;

    @Column(name = "ANOS_EXPERIENCIA")
    private Integer anosExperiencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodinome() {
        return codinome;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoMae() {
        return enderecoMae;
    }

    public void setEnderecoMae(String enderecoMae) {
        this.enderecoMae = enderecoMae;
    }

    public Integer getQuantidadePrisoes() {
        return quantidadePrisoes;
    }

    public void setQuantidadePrisoes(Integer quantidadePrisoes) {
        this.quantidadePrisoes = quantidadePrisoes;
    }

    public String getEspecialidadeRoubo() {
        return especialidadeRoubo;
    }

    public void setEspecialidadeRoubo(String especialidadeRoubo) {
        this.especialidadeRoubo = especialidadeRoubo;
    }

    public Integer getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(Integer anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.cpf);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.codinome);
        hash = 47 * hash + Objects.hashCode(this.telefone);
        hash = 47 * hash + Objects.hashCode(this.endereco);
        hash = 47 * hash + Objects.hashCode(this.enderecoMae);
        hash = 47 * hash + Objects.hashCode(this.quantidadePrisoes);
        hash = 47 * hash + Objects.hashCode(this.especialidadeRoubo);
        hash = 47 * hash + Objects.hashCode(this.anosExperiencia);
        hash = 47 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puxador other = (Puxador) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codinome, other.codinome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.enderecoMae, other.enderecoMae)) {
            return false;
        }
        if (!Objects.equals(this.especialidadeRoubo, other.especialidadeRoubo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantidadePrisoes, other.quantidadePrisoes)) {
            return false;
        }
        if (!Objects.equals(this.anosExperiencia, other.anosExperiencia)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Puxador{" + "id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", codinome="
            + codinome + ", senha=" + senha + ", telefone=" + telefone + ", endereco=" + endereco
            + ", enderecoMae=" + enderecoMae + ", quantidadePrisoes=" + quantidadePrisoes
            + ", especialidadeRoubo=" + especialidadeRoubo + ", anosExperiencia=" + anosExperiencia
            + '}';
    }
}
