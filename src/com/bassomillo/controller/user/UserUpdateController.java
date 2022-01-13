package com.bassomillo.controller.user;

import com.bassomillo.constant.Constant;
import com.bassomillo.entity.Dept;
import com.bassomillo.entity.User;
import com.bassomillo.exception.UserIsExistException;
import com.bassomillo.service.DeptService;
import com.bassomillo.service.UserService;
import com.bassomillo.util.OIUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/user/update")
@MultipartConfig
public class UserUpdateController extends HttpServlet {
    UserService userService = new UserService();
    DeptService deptService = new DeptService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //search all the user
        User user = userService.findUserById(id);
        List<Dept> deptList = deptService.getAllDept();
        //transfer to jsp
        req.setAttribute("user", user);
        req.setAttribute("deptList", deptList);
        req.getRequestDispatcher("/WEB-INF/pages/user/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get data
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String deptId = req.getParameter("deptId");
        String id = req.getParameter("id");
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
                req.getRequestDispatcher("/WEB-INF/errorPages/errorNoProfile.jsp").forward(req,resp);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setId(Integer.parseInt(id));
        user.setDeptId(Integer.parseInt(deptId));
        String fileName = UUID.randomUUID().toString() + "_" + profile.getSubmittedFileName();
        String dir = Constant.BASE_PATH + username + "\\";
        user.setProfile(Constant.BASE_URL_PATH+username + "/"+fileName);

        try {
            Integer rows = userService.update(user);
            req.getRequestDispatcher("/WEB-INF/successPages/operateSuccess.jsp").forward(req,resp);
        }catch (Exception e){
            try {
                req.getRequestDispatcher("/WEB-INF/errorPages/error.jsp").forward(req,resp);
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

