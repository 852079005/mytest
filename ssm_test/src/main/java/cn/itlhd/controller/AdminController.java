package cn.itlhd.controller;

import cn.itlhd.pojo.Admin;
import cn.itlhd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @RequestMapping("/login")
    public void login(String username,String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //2.调用service层
        Admin admin=adminService.login(username,password);

        //3.判断i是否为null
        if (admin != null) {
            //存在用户，跳转
            System.out.println("正确");
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect("/pages/main.html");
        } else {
            //不存在用户,请求转发当前登录页面，提供错误信息
            System.out.println("错误");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script>alert('用户名或密码错误，请重新登录');</script>");

            response.setHeader("refresh", "1;URL=/pages/login.html");
        }
    }
}
