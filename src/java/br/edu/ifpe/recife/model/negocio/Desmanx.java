package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Desmanx implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDesmanx;

    @OneToOne
    private Puxador puxador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDesmanx() {
        return dataDesmanx;
    }

    public void setDataDesmanx(Date dataDesmanx) {
        this.dataDesmanx = dataDesmanx;
    }

    public Puxador getPuxador() {
        return puxador;
    }

    public void setPuxador(Puxador puxador) {
        this.puxador = puxador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dataDesmanx);
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
        final Desmanx other = (Desmanx) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataDesmanx, other.dataDesmanx)) {
            return false;
        }
        if (!Objects.equals(this.puxador, other.puxador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desmanx{" + "id=" + id + ", dataDesmanx=" + dataDesmanx + ", puxador=" + puxador + '}';
    }
}
