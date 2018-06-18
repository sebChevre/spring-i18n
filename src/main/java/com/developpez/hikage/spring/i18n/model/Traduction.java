package com.developpez.hikage.spring.i18n.model;

import lombok.ToString;

@ToString
public class Traduction {

    private Long id;
    private String key;
    private String langue;
    private String pays;
    private String texte;


    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
