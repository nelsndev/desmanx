package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cabrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 7)
    private String placa;

    @Column(length = 17)
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

    @Column(nullable = false)
    private Boolean desmanxFinalizado;

    @OneToOne
    private Modelo modelo;

    @OneToOne
    private Puxador puxador;

    public Cabrito() {
        this.modelo = new Modelo();
        this.puxador = new Puxador();
    }

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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Puxador getPuxador() {
        return puxador;
    }

    public void setPuxador(Puxador puxador) {
        this.puxador = puxador;
    }

    public Boolean getDesmanxFinalizado() {
        return desmanxFinalizado;
    }

    public void setDesmanxFinalizado(Boolean desmanxFinalizado) {
        this.desmanxFinalizado = desmanxFinalizado;
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
        hash = 29 * hash + Objects.hashCode(this.desmanxFinalizado);
        hash = 29 * hash + Objects.hashCode(this.modelo);
        hash = 29 * hash + Objects.hashCode(this.puxador);

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
        if (!Objects.equals(this.desmanxFinalizado, other.desmanxFinalizado)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.puxador, other.puxador)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Cabrito{" + "id=" + id + ", placa=" + placa + ", chassi=" + chassi
            + ", quantidadePortas=" + quantidadePortas + ", cor=" + cor + ", tipoCambio="
            + tipoCambio + ", tipoCombustivel=" + tipoCombustivel + ", observacao=" + observacao
            + ", dataRoubo=" + dataRoubo + ", desmanxFinalizado=" + desmanxFinalizado
            + ", modelo=" + modelo + ", puxador=" + puxador + '}';
    }
}
