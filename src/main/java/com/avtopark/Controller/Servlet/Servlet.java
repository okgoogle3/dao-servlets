package com.avtopark.Controller.Servlet;

import com.avtopark.Controller.Commands.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@WebServlet("/autopark/*")
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if (method.equals("GET") || method.equals("POST")) {
            try{
                ICommand command = ServletHelper.getCommand(req);
                String page = command.execute(req);
                req.getRequestDispatcher(page).forward(req, resp);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            String errMsg = ResourceBundle.getBundle("javax.servlet.http.LocalStrings").getString("http.method_not_implemented");
            Object[] errArgs = new Object[]{method};
            errMsg = MessageFormat.format(errMsg, errArgs);
            resp.sendError(501, errMsg);
        }
    }
}
