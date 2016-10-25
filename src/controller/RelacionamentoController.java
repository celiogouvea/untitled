package controller;


import dao.ContatoDAO;
import dao.ProcessoDAO;
import dao.RelacionamentoDAO;
import model.Contato;
import model.Processo;
import model.Relacionamento;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by pdj_3 on 23/10/2016.
 */
@ManagedBean
public class RelacionamentoController {

    private Relacionamento relacionamento = new Relacionamento();

    public void save(){
        if (RelacionamentoDAO.save(relacionamento)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Salva com Sucesso!", null));
            setRelacionamento(null);
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Erro no Salvamento", null));
        }
    }

    public List<Relacionamento> getListAnd(){
        return  RelacionamentoDAO.getListAnd();
    }
    public List<Relacionamento> getListFI(){
        return  RelacionamentoDAO.getListFI();
    }



    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }
}
