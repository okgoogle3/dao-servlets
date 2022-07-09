package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;
import com.avtopark.Service.EmploymentService;
import com.avtopark.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandFreeUsers implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin){
            request.setAttribute("users", userService.getAllFreeUsers());
            return ConfigPath.users.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
