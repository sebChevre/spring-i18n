package com.developpez.hikage.spring.i18n.controller;

import com.developpez.hikage.spring.i18n.model.Traduction;
import com.developpez.hikage.spring.i18n.model.TraductionsKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.developpez.hikage.spring.i18n.model.TraductionsKey.HELLO_WORLD_LIBELLE;

@RestController
@RequestMapping("/traductions")
public class TraductionsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraductionsController.class.getName());


    final ApplicationContext applicationContext;
    final ExposedResourceBundleMessageSource exposedResourceBundleMessageSource;

    private final static Locale DE_CH = new Locale("de","CH");
    private final static Locale FR_CH = new Locale("fr","CH");
    private final static Locale IT_CH = new Locale("it","CH");


    @Autowired
    public TraductionsController(ApplicationContext applicationContext, ExposedResourceBundleMessageSource exposedResourceBundleMessageSource){
        this.applicationContext = applicationContext;
        this.exposedResourceBundleMessageSource = exposedResourceBundleMessageSource;
    }


    @RequestMapping(value = "/{traductionKey}", method = RequestMethod.GET)
    public String traductionsFor(@PathVariable String traductionKey, @RequestParam final Locale locale){

        LOGGER.info("request params, key: {}, langue: {}",traductionKey,locale);

        LOGGER.info(applicationContext.getMessage(traductionKey, null, locale));

        return applicationContext.getMessage(traductionKey, null, locale);


    }

    @RequestMapping(method = RequestMethod.GET)
    public List<String> allTraductionsFor(@RequestParam final Locale locale){

        LOGGER.info("request params, langue: {}",locale);

        LOGGER.info(applicationContext.getMessage(HELLO_WORLD_LIBELLE.key(), null, locale));

        List<String> libellesParLocale = exposedResourceBundleMessageSource.getKeysAsList("",locale);

        return libellesParLocale;


    }

}

