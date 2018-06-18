package com.developpez.hikage.spring.i18n.service;


import com.developpez.hikage.spring.i18n.model.Traduction;

import java.util.Optional;

public interface TraductionService {

    public Optional<Traduction> getTraduction(String key, String langue, String pays);

}
