package model;

import javax.faces.bean.ManagedBean;

/**
 * Created by pdj_3 on 23/10/2016.
 */
@ManagedBean
public class URL {

    private String pessoa = "pessoa.xhtml";
    private String processo = "processo.xhtml";
    private String andamento = "andamento.xhtml";
    private String cancelado = "cancelado.xhtml";
    private String erro = "erro.xhtml";
    private String index = "index.xhtml";
    private String menu = "menu.xhtml";


    public String getPessoa() {
        return pessoa;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getAndamento() {
        return andamento;
    }

    public void setAndamento(String andamento) {
        this.andamento = andamento;
    }

    public String getCancelado() {
        return cancelado;
    }

    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
