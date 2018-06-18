package com.developpez.hikage.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
public class App  {



    @Autowired
    private ApplicationContext context;



    @PostConstruct
    public void run() throws Exception {
       // jdbcTemplate.execute("DROP TABLE messages IF EXISTS");

        /*jdbcTemplate.execute(
        "CREATE TABLE messages(key VARCHAR(20), langue VARCHAR(2), pays VARCHAR(2), texte VARCHAR(120))");

        jdbcTemplate.execute(
                "INSERT INTO messages(key,langue, pays,texte) " +
                        "VALUES ('helloWorld','fr','FR','coucou')");



*/
        //System.out.println("HelloWorld en français de France : " + context.getMessage("helloWorld", null, Locale.FRANCE));
   //  System.out.println("HelloWorld en Belge : " + context.getMessage("helloWorld", null, new Locale("fr", "BE")));
    //    System.out.println("HelloWorld Italie : " + context.getMessage("helloWorld", null, Locale.ITALY));

    }

    public static void main(String[] args) {


       SpringApplication.run(App.class);
        //log.info("Creating tables");


       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


    }


}
