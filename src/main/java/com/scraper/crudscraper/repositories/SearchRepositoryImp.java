package com.scraper.crudscraper.repositories;

import com.scraper.crudscraper.model.WebPage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SearchRepositoryImp implements SearchRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<WebPage> search(String txtSearch) {
        String query = "FROM WebPage WHERE description like :txtSearch";
        return entityManager
                .createQuery(query)
                .setParameter("txtSearch", "%" + txtSearch + "%")
                .getResultList();
    }

    @Override
    public WebPage getByUrl(String url) {
        String query = "FROM WebPage WHERE url = :url";
        List<WebPage> list = entityManager.createQuery(query)
                .setParameter("url", url)
                .getResultList();
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public List<WebPage> getLinksToIndex() {
        String query = "FROM WebPage WHERE title is null AND description is null";
        return entityManager.createQuery(query)
                .setMaxResults(100)
                .getResultList();
    }
    @Transactional
    @Override
    public void save(WebPage webPage) {
        entityManager.merge(webPage);
    }

    @Override
    public boolean exist(String url) {
        return getByUrl(url) != null;
    }
}
