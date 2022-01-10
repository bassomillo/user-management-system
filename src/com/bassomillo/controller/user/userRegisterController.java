package com.bassomillo.controller.user;

import com.bassomillo.constant.Constant;
import com.bassomillo.entity.User;
import com.bassomillo.exception.UserIsExistException;
import com.bassomillo.service.UserService;
import com.bassomillo.util.OIUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.util.UUID;

@WebServlet("/user/register")
@MultipartConfig
public class userRegisterController extends HttpServlet {
    UserService userservice = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        //1. get data
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Part profile = null;
        InputStream inputStream = null;
        try {
            profile = req.getPart("profile");
            inputStream = profile.getInputStream();
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        if(profile == null || inputStream == null){
            try {
                resp.sendRedirect(req.getContextPath()+"/pages/error.jsp");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String fileName = UUID.randomUUID().toString() + "_" + profile.getSubmittedFileName();
        String dir = Constant.BASE_PATH + username + "\\";
        user.setProfile(Constant.BASE_URL_PATH+username + "/"+fileName);
        try{
            userservice.register(user);
            resp.sendRedirect(req.getContextPath()+"/WEB-INF/successPages/success.jsp");
        }catch (UserIsExistException | IOException e){
            try {
                resp.sendRedirect(req.getContextPath()+"/WEB-INF/errorPages/error.jsp");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        String path = dir +fileName;
        OIUtil.copy(inputStream,path);
    }
}
