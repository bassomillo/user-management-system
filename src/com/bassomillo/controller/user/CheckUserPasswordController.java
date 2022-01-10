package com.bassomillo.controller.user;

import com.bassomillo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/checkUserPassword")
public class CheckUserPasswordController extends HttpServlet {
    UserService userservice = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if(password==null||password==""){
            writer.write("nullPassword");
        }else {
            writer.write("legal password");
            }

            }
}
