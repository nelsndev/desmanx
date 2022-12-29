package br.edu.ifpe.recife.controller;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.negocio.Cabrito;
import br.edu.ifpe.recife.model.negocio.Desmanx;
import br.edu.ifpe.recife.model.negocio.ItemPeca;
import br.edu.ifpe.recife.model.negocio.Peca;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "desmanxCtrl")
@SessionScoped
public class DesmanxController {

    private Desmanx desmanx;
    private Desmanx selecionado;

    @PostConstruct
    public void init() {
        this.desmanx = new Desmanx();
        this.selecionado = null;
    }

    public Desmanx getDesmanx() {
        return desmanx;
    }

    public void setDesmanx(Desmanx desmanx) {
        this.desmanx = desmanx;
    }

    public Desmanx getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Desmanx selecionado) {
        this.selecionado = selecionado;
    }

    public void preencheDesmanx(Cabrito cabrito) {
        this.desmanx.setCabrito(cabrito);
        List<ItemPeca> itensPeca = new ArrayList<>();
        for (Peca peca : cabrito.getModelo().getPecas()) {
            ItemPeca itemPeca = new ItemPeca();
            itemPeca.setPeca(peca);
            itensPeca.add(itemPeca);
        }
        this.desmanx.setItensPeca(itensPeca);
        this.desmanx.setDataDesmanx(new Date());
    }

    public List<Desmanx> readAllOrderByDate() {
        return ManagerDao.getInstance().read(
            "SELECT d FROM Desmanx d ORDER BY d.dataDesmanx DESC", Desmanx.class);
    }

    public void create() {
        if (isItensPecaValido(this.desmanx.getItensPeca())) {
            addDesmanxFinalizadoTrue(this.desmanx.getCabrito());
            ManagerDao.getInstance().create(this.desmanx);
            FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Desmanx realizado com sucesso!"));
            this.desmanx = new Desmanx();
            return;
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,
            "Campo QUANTIDADE não pode ser vazio ou menor que zero", ""));
    }

    public boolean isItensPecaValido(List<ItemPeca> itensPeca) {
        for (ItemPeca ip : itensPeca) {
            if (ip.getQuantidade() == null || ip.getQuantidade() < 0) {
                return false;
            }
        }
        return true;
    }

    public void addDesmanxFinalizadoTrue(Cabrito cabrito) {
        cabrito.setDesmanxFinalizado(true);
        ManagerDao.getInstance().update(cabrito);
    }

    public void update() {
        ManagerDao.getInstance().update(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Desmanx alterado com sucesso!"));
    }

    public void delete() {
        ManagerDao.getInstance().delete(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Desmanx deletado com sucesso!"));
    }

    public List<Desmanx> readAll() {
        return ManagerDao.getInstance().read("SELECT d FROM Desmanx d", Desmanx.class);
    }
}
