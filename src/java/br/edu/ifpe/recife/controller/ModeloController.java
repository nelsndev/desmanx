package br.edu.ifpe.recife.controller;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.negocio.Modelo;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "modeloCtrl")
@SessionScoped
public class ModeloController {

    private Modelo modelo;
    private Modelo selecionado;

    public ModeloController() {
        modelo = new Modelo();
        selecionado = new Modelo();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Modelo getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Modelo selecionado) {
        this.selecionado = selecionado;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void create() {
        ManagerDao.getInstance().create(this.modelo);
        this.modelo = new Modelo();
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Modelo cadastrado com sucesso!"));
    }

    public void update() {
        ManagerDao.getInstance().update(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Modelo alterado com sucesso!"));
    }

    public void delete() {
        ManagerDao.getInstance().delete(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Modelo deletado com sucesso!"));
    }

    public List<Modelo> readAll() {
        return ManagerDao.getInstance()
            .read("SELECT m FROM Modelo m", Modelo.class);
    }
}
