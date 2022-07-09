package com.avtopark.Controller.Commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ICommand {
    String execute(HttpServletRequest request) throws ServletException, IOException;
}
