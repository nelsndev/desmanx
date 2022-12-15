package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemPeca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 100)
    private String avaria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getAvaria() {
        return avaria;
    }

    public void setAvaria(String avaria) {
        this.avaria = avaria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.quantidade);
        hash = 37 * hash + Objects.hashCode(this.avaria);
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
        final ItemPeca other = (ItemPeca) obj;
        if (!Objects.equals(this.avaria, other.avaria)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemPeca{" + "id=" + id + ", quantidade=" + quantidade + ", avaria=" + avaria + '}';
    }
}
