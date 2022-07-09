package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;
import com.avtopark.Service.EmploymentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandEmployment implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        EmploymentService employmentService = new EmploymentService();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin){
            request.setAttribute("employments", employmentService.selectAllEmployments());
            return ConfigPath.employments.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
