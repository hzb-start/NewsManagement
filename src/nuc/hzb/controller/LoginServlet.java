package nuc.hzb.controller;

import nuc.hzb.entity.User;
import nuc.hzb.service.IUserService;
import nuc.hzb.service.impl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄朝博
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String realPassword = request.getParameter("password");
        IUserService iUserService = new UserServiceImpl();
        String salt = iUserService.querySalt(id);
        String password = DigestUtils.sha256Hex(realPassword + salt);
        User user = iUserService.login(id, password);
        if (user != null) {
            System.out.println("登录成功！");
            // 也可以这样处理：如果成功可以将user存入session中，进行重定向到查询主界面
            request.getRequestDispatcher("login_success.jsp").forward(request, response);
        } else {
            System.out.println("登录失败！");
            // 把错误信息和表单项的回传信息，保存到request域中
            request.setAttribute("message", "登录账号或密码错误！");
            request.setAttribute("id", id);
            /*服务器跳转可以传递request范围的属性
            而客户端跳转无法传递request范围的属性
            现在的任务只是告诉前台出现错误以及回传用户已经录入的一些字段（不必麻烦用户再次输入这些字段）
            使用request域即可*/
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
