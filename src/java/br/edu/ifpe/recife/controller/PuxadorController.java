package br.edu.ifpe.recife.controller;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.negocio.Puxador;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "puxadorCtrl")
@SessionScoped
public class PuxadorController {

    private Puxador puxador;
    private Puxador selecionado;

    public PuxadorController() {
        puxador = new Puxador();
        selecionado = new Puxador();
    }

    public Puxador getPuxador() {
        return puxador;
    }

    public Puxador getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Puxador selecionado) {
        this.selecionado = selecionado;
    }

    public void setPuxador(Puxador puxador) {
        this.puxador = puxador;
    }

    public void create() {
        ManagerDao.getInstance().create(this.puxador);
        this.puxador = new Puxador();
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Puxador cadastrado com sucesso!"));
    }

    public void update() {
        ManagerDao.getInstance().update(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Puxador alterado com sucesso!"));
    }

    public void delete() {
        ManagerDao.getInstance().delete(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Puxador deletado com sucesso!"));
    }

    public List<Puxador> readAll() {
        return ManagerDao.getInstance().read("SELECT p FROM Puxador p", Puxador.class);
    }
}
