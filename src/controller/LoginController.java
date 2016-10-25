package controller;


import filter.SessionUtil;
import model.URL;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by pdj_3 on 22/10/2016.
 */
@ManagedBean (name = "controler")
@ViewScoped
public class LoginController {

    private String cpf;
    private String data;
    private Connection conn;
    private Statement comando;
    private ResultSet rs;
    URL url = new URL();

    public void conectar() throws SQLException {
        setConn(conectividade.Conexao.getConexao());
        setComando(getConn().createStatement());
    }

    public void fechar() throws SQLException {
        getComando().close();
        getConn().close();
    }

    public String login() throws SQLException {

        String sql = "SELECT * FROM agenda.CONTATO WHERE CPF = '"+getCpf()+"' AND SENHA = '"+getData()+"'";
        conectar();
        setRs(getComando().executeQuery(sql));
        if (getRs().next()) {
            getRs().close();
            fechar();
            Object b = new Object();
            SessionUtil.setParam("FuncionarioLogado", b);
            return url.getMenu();
        }
        return url.getErro();
    }

    public String registraSaida() {
        //REMOVER USUARIO DA SESSION
        return "index.xhtml?faces-redirect=true";
    }






    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getComando() {
        return comando;
    }

    public void setComando(Statement comando) {
        this.comando = comando;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
