package factory;

import model.Processo;

/**
 * Created by pdj_3 on 22/10/2016.
 */
public class ProcessoFactory {
    public static Processo initialize(){
        Processo processo = new Processo();
        return processo;
    }
}
