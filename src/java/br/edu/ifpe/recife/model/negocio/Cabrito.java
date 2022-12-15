package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cabrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 7)
    private String placa;

    @Column(nullable = false, length = 17)
    private String chassi;

    @Column(length = 5)
    private Integer quantidadePortas;

    @Column(length = 40)
    private String cor;

    @Column(length = 30)
    private String tipoCambio;

    @Column(length = 30)
    private String tipoCombustivel;

    @Column(length = 200)
    private String observacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRoubo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataRoubo() {
        return dataRoubo;
    }

    public void setDataRoubo(Date dataRoubo) {
        this.dataRoubo = dataRoubo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.placa);
        hash = 29 * hash + Objects.hashCode(this.chassi);
        hash = 29 * hash + Objects.hashCode(this.quantidadePortas);
        hash = 29 * hash + Objects.hashCode(this.cor);
        hash = 29 * hash + Objects.hashCode(this.tipoCambio);
        hash = 29 * hash + Objects.hashCode(this.tipoCombustivel);
        hash = 29 * hash + Objects.hashCode(this.observacao);
        hash = 29 * hash + Objects.hashCode(this.dataRoubo);
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
        final Cabrito other = (Cabrito) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.chassi, other.chassi)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.tipoCambio, other.tipoCambio)) {
            return false;
        }
        if (!Objects.equals(this.tipoCombustivel, other.tipoCombustivel)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantidadePortas, other.quantidadePortas)) {
            return false;
        }
        if (!Objects.equals(this.dataRoubo, other.dataRoubo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cabrito{" + "id=" + id + ", placa=" + placa + ", chassi=" + chassi
            + ", quantidadePortas=" + quantidadePortas + ", cor=" + cor + ", tipoCambio="
            + tipoCambio + ", tipoCombustivel=" + tipoCombustivel + ", observacao=" + observacao
            + ", dataRoubo=" + dataRoubo + '}';
    }
}
