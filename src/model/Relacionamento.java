package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by pdj_3 on 23/10/2016.
 */
@Entity
public class Relacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String localizacao;
    private boolean situaca;
    private String idProcesso;
    private String idContato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isSituaca() {
        return situaca;
    }

    public void setSituaca(boolean situaca) {
        this.situaca = situaca;
    }

    public String getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(String idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getIdContato() {
        return idContato;
    }

    public void setIdContato(String idContato) {
        this.idContato = idContato;
    }
}
