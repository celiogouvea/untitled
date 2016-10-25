package controller;

import dao.ContatoDAO;
import factory.ContatoFactory;
import model.Contato;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by pdj_3 on 22/10/2016.
 */
@ManagedBean
//@ApplicationScoped
@ViewScoped
public class ContatoController {

    private Contato contato;

    public void save(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Pessoa Salva com Sucesso!", null));

        if (ContatoDAO.save(contato)){
            // tudo OK
            setContato(null);
            }else {
            //ocorrer algum erro
        }
    }

    public void delete(Contato contato){
        Contato contatoAux = null;
        if(contato != null){
            contatoAux = new Contato();
            contatoAux = contato;
        }
        
        if(ContatoDAO.delete(contatoAux)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Contato excluído com Sucesso!", null));
            System.out.println("Contato excluído com Sucesso!");
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Ocorreu um erro ao Excluir o contato, verifique o console!", null));
        }
    }

    public void alterar(Contato contato) {
        setContato(contato);
        System.out.println("id ->"+contato.getId());
    }





    public List<Contato> getListContato(){
        return  ContatoDAO.getList();
    }




    public Contato getContato() {
        if (contato==null)
            contato = ContatoFactory.initialize();
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}

