package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 75)
    private String nome;

    @Column(nullable = false, length = 75)
    private String fabricante;

    @Column(length = 50)
    private String tipo;

    @Column(name = "MOTOR_POTENCIA", precision = 2)
    private Double motorPotencia;

    @Column(name = "MOTOR_CILINDRADA", precision = 2)
    private Double motorCilindrada;

    @OneToMany
    private List<Peca> pecas;

    public Modelo() {
        this.pecas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMotorPotencia() {
        return motorPotencia;
    }

    public void setMotorPotencia(Double motorPotencia) {
        this.motorPotencia = motorPotencia;
    }

    public Double getMotorCilindrada() {
        return motorCilindrada;
    }

    public void setMotorCilindrada(Double motorCilindrada) {
        this.motorCilindrada = motorCilindrada;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.fabricante);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        hash = 83 * hash + Objects.hashCode(this.motorPotencia);
        hash = 83 * hash + Objects.hashCode(this.motorCilindrada);
        hash = 83 * hash + Objects.hashCode(this.pecas);

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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.motorPotencia, other.motorPotencia)) {
            return false;
        }
        if (!Objects.equals(this.motorCilindrada, other.motorCilindrada)) {
            return false;
        }
        if (!Objects.equals(this.pecas, other.pecas)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Modelo{" + "id=" + id + ", nome=" + nome + ", fabricante=" + fabricante
            + ", tipo=" + tipo + ", motorPotencia=" + motorPotencia + ", motorCilindrada="
            + motorCilindrada + ", pecas=" + pecas + '}';
    }
}
