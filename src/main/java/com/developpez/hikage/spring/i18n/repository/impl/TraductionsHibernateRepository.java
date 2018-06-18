package com.developpez.hikage.spring.i18n.repository.impl;

import com.developpez.hikage.spring.i18n.model.Traduction;
import com.developpez.hikage.spring.i18n.repository.TraductionsRepository;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class TraductionsHibernateRepository extends HibernateRepository implements TraductionsRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraductionsHibernateRepository.class);

    public Optional<Traduction> getTraduction(String cle, String langue, String pays) {

        CriteriaBuilder builder = getSession().getCriteriaBuilder();

        LOGGER.info("Parameters: cle:{}, langue:{}, pays: {}",cle,langue,pays);

        CriteriaQuery<Traduction> criteria = builder.createQuery(Traduction.class);
        Root<Traduction> root = criteria.from(Traduction.class);

        criteria.select(root)
                .where(builder.equal(root.get("key"), cle),
                    builder.equal(root.get("langue"),langue),
                    builder.equal(root.get("pays"),pays));

        Query<Traduction> q = getSession().createQuery(criteria);

        List<Traduction> traductions = q.getResultList();

        LOGGER.info("List all traductions found:");

        traductions.forEach(traduction -> {
            LOGGER.info("Traduction: {}",traduction);
        });

        Traduction t = null;

        if(traductions.size() > 0){
            t =q.list().get(0);
        }


        return Optional.ofNullable(t);


       /** List<String> result = getJdbcTemplate().query("SELECT texte FROM messages WHERE `key` = ? AND langue = ? and pays = ?", new Object[]{cle, langue, pays}, new SingleColumnRowMapper(String.class));
        if (result.size() == 1) return result.get(0);
        else return null;
*/

    }


/**
    public String getMessage(String cle, String langue) {
        List<String> result = getJdbcTemplate().query("SELECT texte FROM messages WHERE `key` = ? AND langue = ? and pays is null", new Object[]{cle, langue}, new SingleColumnRowMapper(String.class));

        if (result.size() == 1) return result.get(0);
        else return null;
    }
 */
}
