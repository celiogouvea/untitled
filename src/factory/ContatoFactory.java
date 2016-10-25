package factory;

import model.Contato;

/**
 * Created by pdj_3 on 22/10/2016.
 */
public class ContatoFactory {
    public static Contato initialize(){
        Contato contato = new Contato();
        return contato;
    }
}
