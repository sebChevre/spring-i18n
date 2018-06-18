package com.developpez.hikage.spring.i18n.controller;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ExposedResourceBundleMessageSource extends
        ResourceBundleMessageSource {

    public Set<String> getKeys(String basename, Locale locale) {
        ResourceBundle bundle = getResourceBundle(basename, locale);
        return bundle.keySet();
    }

    public List<String> getKeysAsList(String basename, Locale locale) {
        ResourceBundle bundle = getResourceBundle(basename, locale);

        return bundle.keySet().stream().collect(Collectors.toList());


    }
}
