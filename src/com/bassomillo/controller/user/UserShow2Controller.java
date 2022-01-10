package com.bassomillo.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.bassomillo.entity.User;
import com.bassomillo.service.UserService;
import com.bassomillo.util.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * user asynchronization method to refresh the website
 */
@WebServlet("/user2")
public class UserShow2Controller extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currentPage = req.getParameter("currentPage") == null ? 1 : Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = req.getParameter("pageSize") == null ? 2 : Integer.parseInt(req.getParameter("pageSize"));

        //search all the user
        List<User> userList = userService.findAllUsers(currentPage,pageSize);
        Integer total = userService.getUserTotal();

        //transfer to jsp
        Page<User> page = new Page<>(total,userList);
        //transfer to frontend
        String pageStr = JSONObject.toJSONString(page);
        System.out.println(pageStr);
//        {"data":[{"deptId":1,"deptName":"Enginnering","id":17,"password":"PbwQ6TSrzQNdS8kvsvBbZw==","profile":"http://localhost:8080/img/lucy2/b6d9f187-73cd-4c66-9a1e-9f9289e4d21a_图片3.jpg",
//        "username":"lucy2"},{"deptId":3,"deptName":"Finance","id":20,"password":"TCzODhAhQYetWPeXWRHHaQ==","profile":"http://localhost:8080/img/lucyhjk/0f45a0b6-952f-4971-9e0c-1a2c410e5a48_微信图片_20210907142333.jpg","username":"lucyhjk"}],"total":4}
        resp.setHeader("Content-Type","application/json;charset=utf-8");
        resp.getWriter().write(pageStr);
        resp.getWriter().flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/user/user2.jsp").forward(req,resp);
    }
}
