package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;
import com.avtopark.Service.BusService;
import com.avtopark.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandFreeBuses implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        BusService busService = new BusService();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin){
            request.setAttribute("buses", busService.getAllFreeBuses());
            return ConfigPath.buses.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
