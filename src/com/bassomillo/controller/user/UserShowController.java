package com.bassomillo.controller.user;

import com.bassomillo.entity.User;
import com.bassomillo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserShowController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currentPage = req.getParameter("currentPage") == null ? 1 : Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = req.getParameter("pageSize") == null ? 2 : Integer.parseInt(req.getParameter("pageSize"));

        //search all the user
        List<User> userList = userService.findAllUsers(currentPage,pageSize);
        Integer total = userService.getUserTotal();

        //transfer to jsp
        req.setAttribute("userList",userList);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("pageSize",pageSize);

        req.setAttribute("totalPage",(int)Math.ceil(((double)total)/pageSize));
        req.getRequestDispatcher("/WEB-INF/pages/user/user.jsp").forward(req,resp);
    }
}
