package org.example.webdemo.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.example.webdemo.service.WebService;
import java.io.IOException;

public class WebServiceImpl implements WebService {
    private final String url = "https://www.ntv.com.tr";
    private final String cssQuery = "title";

    @Override
    public String getTitle() throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(cssQuery);
        String text = "";
        for (Element element : elements) {
            text = element.text();
            break;
        }
        return text;
    }
}
