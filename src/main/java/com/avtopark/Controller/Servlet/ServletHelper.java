package com.avtopark.Controller.Servlet;

import com.avtopark.Controller.Commands.ECommand;
import com.avtopark.Controller.Commands.ICommand;
import com.avtopark.Controller.ConfigPath;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

public class ServletHelper {
    public static ICommand getCommand(HttpServletRequest request){
        String name = request.getParameter("command");
        if(name == null) return ECommand.home.getCommand();
        try{
            return ECommand.valueOf(name).getCommand();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return ECommand.home.getCommand();
    }
}
