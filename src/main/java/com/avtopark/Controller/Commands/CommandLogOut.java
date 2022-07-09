package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandLogOut implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return ConfigPath.login.getJspPath();
    }
}
