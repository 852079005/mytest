package cn.itlhd.interceptor;

import cn.itlhd.pojo.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器（拦截器），查看用户是否登陆过，未登录禁止访问页面
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器执行");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 获得请求的URL
        String url = request.getRequestURL().toString();
        System.out.println(url);

        //根据session获取是否存在用户
        Admin admin = (Admin) request.getSession().getAttribute("admin");

        // 使用endsWith()判断url结尾的字符串
        //由输出URL可观察到，login.jsp页面存在css资源和ico资源，顺带将无关紧要的资源不屏蔽
        if (url.endsWith("login.html") || admin != null || url.endsWith("login.action") || url.endsWith(".css")

                || url.endsWith(".js") || url.endsWith(".gif")

                || url.endsWith(".png") || url.endsWith(".jpg")

                || url.endsWith(".ico") || url.endsWith("userServlet")
                ) {

            chain.doFilter(request, response);

        } else {
            //不满足条件重定向
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('请先登录');top.location.href='/pages/login.html'</script>");

        }

        /*//根据session获取是否存在用户
        User user = (User) request.getSession().getAttribute("user");
        //判断
        if (user != null) {
            //存在，放行
            chain.doFilter(request, response);
        } else {
            //不存在，跳转到登录页面
            System.out.println("跳转到登录页面");

            response.sendRedirect(request.getContextPath() + "/login.jsp");
            chain.doFilter(request, response);

        }*/

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
