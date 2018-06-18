package com.developpez.hikage.spring.i18n.repository;


import com.developpez.hikage.spring.i18n.model.Traduction;

import java.util.Optional;

public interface TraductionsRepository {

    Optional<Traduction> getTraduction(String cle, String langue, String pays);
}
