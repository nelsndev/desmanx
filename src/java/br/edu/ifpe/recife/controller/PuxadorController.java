package br.edu.ifpe.recife.controller;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.negocio.Puxador;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "puxadorCtrl")
@SessionScoped
public class PuxadorController {

    private Puxador puxador;
    private Puxador selecionado;

    @PostConstruct
    public void init() {
        this.puxador = new Puxador();
        this.selecionado = null;
    }

    public void create(String confirmacao) {
        if (!this.puxador.getSenha().equals(confirmacao)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "A senha informada não confirma", ""));
            return;
        }

        ManagerDao.getInstance().create(this.puxador);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Puxador cadastrado com sucesso!"));
        this.puxador = new Puxador();
    }

    public void update(String confirmacao) {
        if (!this.selecionado.getSenha().equals(confirmacao)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "A senha informada não confirma", ""));
            return;
        }

        ManagerDao.getInstance().update(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Puxador alterado com sucesso!"));
    }

    public void alteraInformacoes(Puxador puxador) {
        ManagerDao.getInstance().update(puxador);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Informações alteradas com sucesso!"));
    }

    public void alteraSenha(String senhaAtual, String novaSenha, String confirmacao) {
        HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
            .getSession(true);
        LoginController lc = (LoginController) hs.getAttribute("loginCtrl");
        Puxador puxadorLogado = lc.getPuxadorLogado();

        if (!senhaAtual.equals(puxadorLogado.getSenha())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Senha atual incorreta", ""));
            return;
        }

        if (!novaSenha.equals(confirmacao)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "A senha informada não confirma", ""));
            return;
        }

        puxadorLogado.setSenha(novaSenha);
        ManagerDao.getInstance().update(puxadorLogado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Senha alterada com sucesso!"));
    }

    public void delete() {
        ManagerDao.getInstance().delete(this.selecionado);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Puxador deletado com sucesso!"));
    }

    public List<Puxador> readAll() {
        return ManagerDao.getInstance().read("SELECT p FROM Puxador p", Puxador.class);
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
}
