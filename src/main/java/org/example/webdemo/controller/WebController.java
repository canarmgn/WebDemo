package org.example.webdemo.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.example.webdemo.repository.WebRepository;
import org.example.webdemo.service.WebService;
import org.example.webdemo.service.impl.WebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    WebService webService;

    @PostMapping("/web")
    public String getTitle() throws SQLException, IOException {
       return webService.getTitle();


    }


}
