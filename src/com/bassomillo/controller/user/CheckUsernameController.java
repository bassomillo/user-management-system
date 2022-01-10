package com.bassomillo.controller.user;

import com.bassomillo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/checkUserName")
public class CheckUsernameController extends HttpServlet {
    UserService userservice = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Boolean flag = userservice.CheckUserName(username);
        PrintWriter writer = resp.getWriter();
        if(username==null|| "".equals(username)){
            writer.write("nullUsername");
        }else {
                if(flag){
                    writer.write("yes");
                }else {
                    writer.write("no");

                }
            }
        }
}
