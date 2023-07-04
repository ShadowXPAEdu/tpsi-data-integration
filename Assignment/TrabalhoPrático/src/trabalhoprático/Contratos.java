/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoprático;

/**
 *
 * @author ShadowXPA
 */
public class Contratos {
    String municipio;
    String nif;
    String objcontrato;
    String preco;
    String datapub;
    String adjudicatario;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getObjcontrato() {
        return objcontrato;
    }

    public void setObjcontrato(String objcontrato) {
        this.objcontrato = objcontrato;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDatapub() {
        return datapub;
    }

    public void setDatapub(String datapub) {
        this.datapub = datapub;
    }

    public String getAdjudicatario() {
        return adjudicatario;
    }

    public void setAdjudicatario(String adjudicatario) {
        this.adjudicatario = adjudicatario;
    }
    
    public Contratos(String municipio, String nif, String objcontrato, String preco, String datapub, String adjudicatario) {
        this.municipio = municipio;
        this.nif = nif;
        this.objcontrato = objcontrato;
        this.preco = preco;
        this.datapub = datapub;
        this.adjudicatario = adjudicatario;
    }
}
