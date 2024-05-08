package org.example.webdemo.service;
import org.example.webdemo.controller.WebController;

import java.io.IOException;
import java.sql.SQLException;


public interface WebService {
    String getTitle() throws SQLException,IOException;
}
