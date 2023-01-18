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

    public void adicionaCabrito(Cabrito cabrito) {
        List<ItemPeca> itemPecaList = new ArrayList<>();
        for (Peca peca : cabrito.getModelo().getPecas()) {
            ItemPeca itemPeca = new ItemPeca();
            itemPeca.setPeca(peca);
            itemPecaList.add(itemPeca);
        }
        this.desmanx.setCabrito(cabrito);
        this.desmanx.setItensPeca(itemPecaList);
    }

    public List<Desmanx> readAllOrderByDate() {
        return ManagerDao.getInstance().read(
            "SELECT d FROM Desmanx d ORDER BY d.dataDesmanx DESC", Desmanx.class);
    }

    public void create() {
        List<ItemPeca> ItemPecaList = this.desmanx.getItensPeca();
        int itensAusentesCount = 0;

        for (ItemPeca itemPeca : ItemPecaList) {
            if (itemPeca.getQuantidade() == null || itemPeca.getQuantidade() <= 0) {
                itemPeca.setQuantidade(0);
                itensAusentesCount++;
            }
        }
        if (itensAusentesCount == ItemPecaList.size()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Não pode haver desmanx sem peças!", ""));
            return;
        }

        // Faz com que o puxador saiba que o seu cabrito cadastrado foi desmanxado
        Cabrito cabrito = this.desmanx.getCabrito();
        cabrito.setDesmanxFinalizado(true);
        ManagerDao.getInstance().update(cabrito);

        this.desmanx.setDataDesmanx(new Date());
        ManagerDao.getInstance().create(this.desmanx);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Desmanx realizado com sucesso!"));
        this.desmanx = new Desmanx();
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
}
