package factory;

import model.Relacionamento;

/**
 * Created by pdj_3 on 23/10/2016.
 */
public class RelacionamentoFactory {
    public static Relacionamento initialize(){
        Relacionamento relacionamento = new Relacionamento();
        return relacionamento;
    }
}
