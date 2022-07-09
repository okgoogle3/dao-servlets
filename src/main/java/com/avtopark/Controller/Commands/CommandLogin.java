package com.avtopark.Controller.Commands;

import com.avtopark.Controller.ConfigPath;
import com.avtopark.Model.Entities.User;
import com.avtopark.Service.Dto.UserDto;
import com.avtopark.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandLogin implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = userService.isUserExists(username, password);
        if(user != null){
            session.setAttribute("registered", true);
            session.setAttribute("user", user);
            if(userService.isUserAdmin(user.id()))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            return ConfigPath.home.getJspPath();
        }
        else request.setAttribute("incorrect", true);
        session.setAttribute("registered", false);
        return ConfigPath.login.getJspPath();
    }
}
