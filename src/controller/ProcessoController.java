package controller;

import dao.ProcessoDAO;
import factory.ProcessoFactory;
import model.Processo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by pdj_3 on 22/10/2016.
 */
@ManagedBean
@ViewScoped
public class ProcessoController {
    private Processo processo;

    public void save(){
        if (ProcessoDAO.save(processo)){
            // tudo OK
            setContato(null);
        }else{
            //ocorrer algum erro
        }
    }
    public void delete(Processo contato){
        Processo processoAux = null;

        if (contato != null){
            processoAux = new Processo();
            processoAux = contato;
        }


        if(ProcessoDAO.delete(processoAux)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Processo excluído com Sucesso!", null));
            System.out.println("Contato excluído com Sucesso!");
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao Excluir o Processo, verifique o console!", null));
        }
    }

    public void alterar(Processo contato) {
        setContato(contato);
    }





    public List<Processo> getListProcesso(){
        return  ProcessoDAO.getList();
    }




    public Processo getProcesso() {
        if (processo==null)
            processo = ProcessoFactory.initialize();
        return processo;
    }

    public void setContato(Processo processo) {

        this.processo = processo;
    }






}
