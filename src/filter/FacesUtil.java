package filter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by pdj_3 on 23/10/2016.
 */
public class FacesUtil {

    public static boolean isPostBack(){
        return FacesContext.getCurrentInstance().isPostback();
    }
    public static boolean isNotPostback(){
        return isPostBack();
    }
    public static  void addErrorMensagem(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,mensagem));
    }
    public static void aaInfoMensagem(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,mensagem));
    }
}
