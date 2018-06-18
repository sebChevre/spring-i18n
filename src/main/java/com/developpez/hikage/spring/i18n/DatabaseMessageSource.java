package com.developpez.hikage.spring.i18n;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.Optional;

import com.developpez.hikage.spring.i18n.model.Traduction;
import com.developpez.hikage.spring.i18n.service.TraductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMessageSource extends AbstractMessageSource {

    @Autowired
    private TraductionService traductionService;


    protected MessageFormat resolveCode(String key, Locale locale) {


        // Utilisation du service pour récuperer le message traduit
        Optional<Traduction> traduction = traductionService.getTraduction(key, locale.getLanguage(), locale.getCountry());
        // Et renvoie de celui-ci sous la bonne forme
        return createMessageFormat(traduction.get().getTexte(), locale);

    }
}
