package com.scraper.crudscraper.repositories;

import com.scraper.crudscraper.model.WebPage;

import java.util.List;

public interface SearchRepository {
    public List<WebPage> search(String txtSearch);

    WebPage getByUrl(String url);

    List<WebPage> getLinksToIndex();

    void save(WebPage webPage);

    boolean exist(String link);
}
