package com.developpez.hikage.spring.i18n.model;

public enum TraductionsKey {

    HELLO_WORLD_LIBELLE("helloworld.lbl");

    private final String key;

    TraductionsKey(String key){
        this.key = key;
    }

    public String key() {
        return key;
    }
}
