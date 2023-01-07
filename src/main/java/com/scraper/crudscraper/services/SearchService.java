package com.scraper.crudscraper.services;

import com.scraper.crudscraper.model.WebPage;
import com.scraper.crudscraper.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService   {

    @Autowired
    private SearchRepository searchRepository;
    public List<WebPage> search(String txtSearch) {
        return searchRepository.search(txtSearch);
    }
    public void save(WebPage webPage) {
        searchRepository.save(webPage);
    }
    public boolean exist(String link) {
        return searchRepository.exist(link);
    }

    public List<WebPage> getLinksToIndex() {
        return searchRepository.getLinksToIndex();
    }
}
