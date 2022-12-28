package br.edu.ifpe.recife.controller;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.negocio.Cabrito;
import br.edu.ifpe.recife.model.negocio.Puxador;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "cabritoCtrl")
@SessionScoped
public class CabritoController {

    private Cabrito cabrito;
    private Cabrito selecionado;

    @PostConstruct
    public void init() {
        this.cabrito = new Cabrito();
        this.selecionado = null;
    }

    public Cabrito getCabrito() {
        return cabrito;
    }

    public void setCabrito(Cabrito cabrito) {
        this.cabrito = cabrito;
    }

    public Cabrito getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Cabrito selecionado) {
        this.selecionado = selecionado;
    }

    public void create(Puxador puxador) {
        this.cabrito.setPuxador(puxador);
        this.cabrito.setDesmanxFinalizado(false);
        this.cabrito.setDataRoubo(new Date());
        ManagerDao.getInstance().create(this.cabrito);
        this.cabrito = new Cabrito();
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Cabrito adicionado com sucesso!"));
    }

    public List<Cabrito> readAllByPuxador(Puxador puxador) {
        String query = String.format("SELECT c FROM Cabrito c WHERE c.puxador.id = %s"
            + " ORDER BY c.desmanxFinalizado, c.dataRoubo DESC", puxador.getId());
        return ManagerDao.getInstance().read(query, Cabrito.class);
    }

    public List<Cabrito> readAllNotFinished() {
        return ManagerDao.getInstance().read(
            "SELECT c FROM Cabrito c WHERE c.desmanxFinalizado = false ORDER BY c.dataRoubo DESC",
            Cabrito.class);
    }

    public void update() {
        ManagerDao.getInstance().update(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Cabrito alterado com sucesso!"));
    }

    public void delete() {
        ManagerDao.getInstance().delete(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Cabrito deletado com sucesso!"));
    }

    public List<Cabrito> readAll() {
        return ManagerDao.getInstance().read("SELECT c FROM Cabrito c", Cabrito.class);
    }
}
