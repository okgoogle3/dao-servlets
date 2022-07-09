package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;
import com.avtopark.Model.Entities.User;
import com.avtopark.Service.EmploymentService;
import com.avtopark.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandProfile implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        EmploymentService employmentService = new EmploymentService();
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered){
            User user = (User) session.getAttribute("user");
            request.setAttribute("resultField", employmentService.selectEmployment(user.id()));
            return ConfigPath.profile.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
