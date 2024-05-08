package org.example.webdemo.service.impl;

import org.example.webdemo.repository.WebRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.example.webdemo.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.SQLException;


@Service
public class WebServiceImpl implements WebService {
    private final String url = "https://www.ntv.com.tr";
    private final String cssQuery = "title";

    @Autowired
    private WebRepository webRepository;


    @Override
    public String getTitle() throws SQLException, IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(cssQuery);
        String text = "";
        for (Element element : elements) {
            text = element.text();
            break;
        }


        webRepository.save(text);


        return text;
    }
}
