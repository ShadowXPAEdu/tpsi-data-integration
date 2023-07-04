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
public class Camaras {
    String municipio;
    String presidenteC;
    String presidenteA;
    String email;
    String site;
    String telefone;
    String numFreg;
    String area;
    String numHab;
    String feriado;
    String brasao;

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPresidenteC() {
        return presidenteC;
    }

    public void setPresidenteC(String presidenteC) {
        this.presidenteC = presidenteC;
    }

    public String getPresidenteA() {
        return presidenteA;
    }

    public void setPresidenteA(String presidenteA) {
        this.presidenteA = presidenteA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumFreg() {
        return numFreg;
    }

    public void setNumFreg(String numFreg) {
        this.numFreg = numFreg;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumHab() {
        return numHab;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public String getFeriado() {
        return feriado;
    }

    public void setFeriado(String feriado) {
        this.feriado = feriado;
    }

    public String getBrasao() {
        return brasao;
    }

    public void setBrasao(String brasao) {
        this.brasao = brasao;
    }

    public Camaras(String municipio, String presidenteC, String presidenteA, String email, String site, String telefone, String numFreg, String area, String numHab, String feriado, String brasao) {
        this.municipio = municipio;
        this.presidenteC = presidenteC;
        this.presidenteA = presidenteA;
        this.email = email;
        this.site = site;
        this.telefone = telefone;
        this.numFreg = numFreg;
        this.area = area;
        this.numHab = numHab;
        this.feriado = feriado;
        this.brasao = brasao;
    }
}
