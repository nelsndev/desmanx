package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
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
    private Cabrito cabrito;

    @ElementCollection
    private List<ItemPeca> itensPeca;

    public Desmanx() {
        this.dataDesmanx = new Date();
        this.cabrito = new Cabrito();
        this.itensPeca = new ArrayList<>();
    }

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

    public Cabrito getCabrito() {
        return cabrito;
    }

    public void setCabrito(Cabrito cabrito) {
        this.cabrito = cabrito;
    }

    public List<ItemPeca> getItensPeca() {
        return itensPeca;
    }

    public void setItensPeca(List<ItemPeca> itensPeca) {
        this.itensPeca = itensPeca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dataDesmanx);
        hash = 29 * hash + Objects.hashCode(this.cabrito);
        hash = 29 * hash + Objects.hashCode(this.itensPeca);
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
        if (!Objects.equals(this.cabrito, other.cabrito)) {
            return false;
        }
        if (!Objects.equals(this.itensPeca, other.itensPeca)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desmanx{" + "id=" + id + ", dataDesmanx=" + dataDesmanx + ", cabrito=" + cabrito
            + ", itensPeca=" + itensPeca + '}';
    }
}
