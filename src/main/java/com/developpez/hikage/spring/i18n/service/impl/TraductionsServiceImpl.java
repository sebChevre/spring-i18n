package com.developpez.hikage.spring.i18n.service.impl;

import com.developpez.hikage.spring.i18n.model.Traduction;
import com.developpez.hikage.spring.i18n.service.TraductionService;
import com.developpez.hikage.spring.i18n.repository.TraductionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class TraductionsServiceImpl implements TraductionService {

    // Propriété pour connaitre  
    private String langueDefaut = "fr";

    @Autowired
    private TraductionsRepository traductionRepository;



    // Setter de la langue par défaut
    public void setLangueDefaut(String langueDefaut) {
        this.langueDefaut = langueDefaut;
    }

    @Transactional
    public Optional<Traduction> getTraduction(String cle, String langue, String pays) {

        // Si un message pour la locale complète existe
        Optional<Traduction> traduction = traductionRepository.getTraduction(cle, langue, pays);

        // On le renvoit
        if (traduction.isPresent()) return traduction;

        // Sinon on cherche un message basé sur la langue uniquement
        //message = traductionRepository
         //       .getMessage(cle, langue);
        // Et on le retourne si il y en a un
        //if (message != null) return message;

        // Sinon on cherche un message dans la langue par defaut
        //message = messageDao.getMessage(cle, langueDefaut);
        //if (message != null) return message;

        // Si le message n'existe pas on renvoit une chaine spéciale
        return Optional.empty();
    }

}
