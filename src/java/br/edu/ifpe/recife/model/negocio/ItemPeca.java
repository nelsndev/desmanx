package br.edu.ifpe.recife.model.negocio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class ItemPeca implements Serializable {

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 100)
    private String avaria;

    @OneToOne
    private Peca peca;

    public ItemPeca() {
        this.peca = new Peca();
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

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.quantidade);
        hash = 37 * hash + Objects.hashCode(this.avaria);
        hash = 37 * hash + Objects.hashCode(this.peca);
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
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.peca, other.peca)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemPeca{" + "quantidade=" + quantidade + ", avaria=" + avaria + ", peca="
            + peca + '}';
    }
}
