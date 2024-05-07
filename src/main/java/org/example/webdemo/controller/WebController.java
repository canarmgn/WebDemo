package org.example.webdemo.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.example.webdemo.repository.WebRepository;
import org.example.webdemo.service.WebService;
import org.example.webdemo.service.impl.WebServiceImpl;

public class WebController {
    private final WebService webService = new WebServiceImpl();
    private final WebRepository webRepository = new WebRepository() {
        @Override
        public void save(String title) throws SQLException {
            // Burada veritabanına kaydetme işlemi gerçekleştirilebilir.
            System.out.println("Veri başarıyla veritabanına kaydedildi.");
        }
    };

    public void saveTitleToDatabase() {
        try {
            String title = webService.getTitle();
            webRepository.save(title);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.err.println("Bir hata oluştu.");
        }
    }
}
