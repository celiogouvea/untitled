package filter;

import com.sun.deploy.net.HttpResponse;
import model.URL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pdj_3 on 23/10/2016.
 */
@WebFilter(servletNames = {"Faces Servlet"})
public class ControllerAcesso  implements Filter{

    URL url = new URL();

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        if ((session.getAttribute("FuncionarioLogado") != null)
                || (req.getRequestURI().endsWith("index.xhtml"))
                || (req.getRequestURI().contains("javax.faces.resource/"))) {



            //redireciona("/Logado.xhtml", response);

            filterChain.doFilter(servletRequest, servletResponse);
        }

        else {
            redireciona(url.getIndex(), servletResponse);
        }




    }

    public void destroy() {

    }
    private void redireciona(String url, ServletResponse response)
            throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);
    }
}
