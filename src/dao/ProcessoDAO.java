package dao;

import factory.JPSFactory;
import model.Processo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by pdj_3 on 22/10/2016.
 */
public class ProcessoDAO {

    private static EntityManager em;

    public static EntityManager getEm(){
        if ( em ==null)
            em = JPSFactory.getEntityManager();
        return em;
    }

    public static boolean save (Processo processo){
        try{
            getEm().getTransaction().begin();
            getEm().persist(processo);
            getEm().getTransaction().commit();
            return true;
        }catch (Exception e){
            if (getEm().getTransaction().isActive())
                getEm().getTransaction().rollback();
        }
        return false;
    }

    public static List<Processo> getList(){
        Query query = getEm().createQuery("select c from Processo c order by c.id ");
        return query.getResultList();
    }

    public static Processo buscar(Integer id) {
        try {
            return getEm().getReference(Processo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que deleta um contato no banco
     * @param entity
     * @return boolean
     */
    public static boolean delete (Processo entity){
        try{
            getEm().getTransaction().begin();
            getEm().remove(entity);
            getEm().getTransaction().commit();
            return true;
        }catch (Exception e){
            if(getEm().getTransaction().isActive())
                getEm().getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }


}
