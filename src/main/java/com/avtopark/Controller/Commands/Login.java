package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Login implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return ConfigPath.login.getJspPath();
    }
}
