package dao;

import factory.JPSFactory;
import model.Contato;
import model.Processo;
import model.Relacionamento;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by pdj_3 on 23/10/2016.
 */
@ManagedBean(name="RelacionamentoDAO", eager = true)
public class RelacionamentoDAO {
    private static EntityManager em;

    public static EntityManager getEm(){
        if ( em ==null)
            em = JPSFactory.getEntityManager();
        return em;
    }

    public static boolean save (Relacionamento relacionamento) {
        try {
            getEm().getTransaction().begin();
            getEm().persist(relacionamento);
            getEm().getTransaction().commit();
            System.out.println("relacinamento");
            return true;
        } catch (Exception e) {
            if (getEm().getTransaction().isActive())
                getEm().getTransaction().rollback();
        }
        return false;
    }



    public static List<Relacionamento> getListFI(){
        Query query = getEm().createQuery("select p from Relacionamento p where p.situaca != true order by p.id");
        return query.getResultList();
    }
    public static List<Relacionamento> getListAnd(){
        Query query = getEm().createQuery("select p from Relacionamento p where p.situaca != false order by p.id");
        return query.getResultList();
    }

    public List<Relacionamento> getTheme(){
        Query query = getEm().createQuery("select p from Relacionamento p order by p.id");
        return query.getResultList();
    }

}
