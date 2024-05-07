package org.example.webdemo;

import org.example.webdemo.controller.WebController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebDemoApplication {
    public static void main(String[] args) {
        WebController webController = new WebController();
        webController.saveTitleToDatabase();
    }
}
