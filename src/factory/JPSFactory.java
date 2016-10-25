package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by pdj_3 on 22/10/2016.
 */
public class JPSFactory {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
