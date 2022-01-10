package com.bassomillo.controller.user;

import com.bassomillo.entity.User;
import com.bassomillo.exception.UserIsNotExistException;
import com.bassomillo.exception.WrongPasswordException;
import com.bassomillo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String verification = req.getParameter("verification");
        HttpSession session = req.getSession();
        String verification1 = (String)session.getAttribute("verification ");
        if(!verification1.equals(verification)){
            req.getRequestDispatcher("/WEB-INF/errorPages/errorWrongVerificationNumber.jsp").forward(req,resp);
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            userService.login(user);
            session.setAttribute("user",user);
//            resp.sendRedirect(req.getContextPath()+"/pages/success.jsp");
//            Thread.sleep(1000);
//            req.getRequestDispatcher("/user").forward(req,resp);
//            resp.sendRedirect(req.getContextPath()+"/WEB-INF/pages/user/user.jsp");
            resp.sendRedirect(req.getContextPath()+"/user");
        }catch (UserIsNotExistException e){
            req.getRequestDispatcher("/WEB-INF/errorPages/errorWrongUserName.jsp").forward(req,resp);

        }catch (WrongPasswordException e){
            req.getRequestDispatcher("/WEB-INF/errorPages/errorWrongPassword.jsp").forward(req,resp);

        }
    }
}
