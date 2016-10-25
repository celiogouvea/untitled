package filter;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by pdj_3 on 23/10/2016.
 */
public class SessionUtil implements Serializable{

    private static final long serialVersionUID = 1L;

    public static HttpSession getSession(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) ctx.getExternalContext().getSession(false);
        return sessao;
    }
    public static void setParam(String key, Object valor){
        getSession().setAttribute(key, valor);
    }
    public static Object getPAram(String key){
        return getSession().getAttribute(key);
    }
    public static void remove(String key){
        getSession().removeAttribute(key);
    }
    public static void invalidate(){
        getSession().invalidate();
    }

}
