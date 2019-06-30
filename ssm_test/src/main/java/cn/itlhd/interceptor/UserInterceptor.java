package cn.itlhd.interceptor;

import cn.itlhd.pojo.Admin;
import cn.itlhd.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInterceptor implements HandlerInterceptor {

    /**
     * controller方法执行前，进行拦截的方法
     * return true放行
     * return false拦截
     * 可以使用转发或者重定向直接跳转到指定的页面。
     * 需要在springmvc.xml中配置拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("拦截器拦截了");
        String URI = request.getRequestURI();
        System.out.println("请求的资源是:" + URI);


       /* Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin == null) {
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect("/pages/login.html");
            return false;
        }*/

        //表示登陆
        return true;
    }
}
