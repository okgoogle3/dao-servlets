package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;
import com.avtopark.Service.RouteService;
import com.avtopark.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandFreeRoutes implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        RouteService routeService = new RouteService();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin){
            request.setAttribute("routes", routeService.getAllFreeRoutes());
            return ConfigPath.routes.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
