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

    public ModeloController() {
        modelo = new Modelo();
    }

    public Modelo getModelo() {
        return modelo;
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

    public List<Modelo> readAll() {
        return ManagerDao.getInstance()
            .read("SELECT m FROM Modelo m", Modelo.class);
    }
}
