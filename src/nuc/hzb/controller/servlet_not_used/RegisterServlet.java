package nuc.hzb.controller.servlet_not_used;

import nuc.hzb.entity.User;
import nuc.hzb.service.IUserService;
import nuc.hzb.service.impl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author 黄朝博
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理编码问题
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String realPassword = request.getParameter("password");
        String salt = UUID.randomUUID().toString();
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        Date date = new Date();
        String password = DigestUtils.sha256Hex(realPassword + salt);
        User user = new User(id, name, password, salt, sex, email, date);
        // 调用service层
        IUserService iUserService = new UserServiceImpl();
        // 如果成功将直接保存到数据库中
        int register = iUserService.register(user);
        if (register == -1) {
            System.out.println("注册失败！");
            request.setAttribute("message", id + "已存在！");
            request.setAttribute("name", name);
            request.setAttribute("sex", sex);
            request.setAttribute("email", email);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            System.out.println("注册成功！");
            request.getRequestDispatcher("register_success.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
