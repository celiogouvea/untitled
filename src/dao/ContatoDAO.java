package dao;

import model.Contato;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import factory.JPSFactory;

/**
 * Created by pdj_3 on 22/10/2016.
 */
public class ContatoDAO {
    private static EntityManager em;

    public static EntityManager getEm(){
        if ( em ==null)
            em = JPSFactory.getEntityManager();
        return em;
    }

    public static boolean save (Contato contato){
        try{
            getEm().getTransaction().begin();
            getEm().persist(contato);
            getEm().getTransaction().commit();
            return true;
        }catch (Exception e){
            if (getEm().getTransaction().isActive())
                getEm().getTransaction().rollback();
        }

        return false;
    }

    public static List<Contato> getList(){
        Query query = getEm().createQuery("select c from Contato c order by c.Nome ASC");
        return query.getResultList();
    }

    public static boolean delete (Contato contato){
        try{
            getEm().getTransaction().begin();
            getEm().remove(contato);
            getEm().getTransaction().commit();
            return true;
        }catch (Exception e){
            if(getEm().getTransaction().isActive())
                System.out.println("delete4 ");
                getEm().getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }



    public static Contato buscar(Integer id) {
        System.out.println("Função buscar------------>");
        try {
            System.out.println("busca1 ");
            return getEm().getReference(Contato.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("busca2 ");
        }
        return null;
    }





}
