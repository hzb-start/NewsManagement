package nuc.hzb.controller;

import nuc.hzb.entity.User;
import nuc.hzb.service.IUserService;
import nuc.hzb.service.impl.UserServiceImpl;
import nuc.hzb.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author 黄朝博
 */
public class UserServlet extends BaseServlet {

    /**
     * 处理登录的功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String realPassword = request.getParameter("password");
        IUserService iUserService = new UserServiceImpl();
        String salt = iUserService.querySalt(id);
        String password = WebUtils.encryptPassword(realPassword + salt);
        User user = iUserService.login(id, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            System.out.println("登录成功！");
            request.getRequestDispatcher("pages/user/login_success.jsp").forward(request, response);
        } else {
            System.out.println("登录失败！");
            request.setAttribute("message", "登录账号或密码错误！");
            request.setAttribute("id", id);
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
        }
    }


    /**
     * 处理注册的功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String realPassword = request.getParameter("password");
        String salt = UUID.randomUUID().toString();
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        Date date = new Date();
        String password = WebUtils.encryptPassword(realPassword + salt);
        User user = new User(id, name, password, salt, sex, email, date);
        IUserService iUserService = new UserServiceImpl();
        int register = iUserService.register(user);
        if (register == -1) {
            System.out.println("注册失败！");
            request.setAttribute("message", id + "已存在！");
            request.setAttribute("name", name);
            request.setAttribute("sex", sex);
            request.setAttribute("email", email);
            request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
        } else {
            System.out.println("注册成功！");
            request.getRequestDispatcher("pages/user/register_success.jsp").forward(request, response);
        }
    }


    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getSession().invalidate();
       response.sendRedirect(request.getContextPath());
    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String action = request.getParameter("action");
////        优化，不使用判断语句，使用反射来调用方法
////        if ("login".equals(action)) {
////            login(request, response);
////        } else if ("register".equals(action)) {
////            register(request, response);
////        }
//        try {
//            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            method.invoke(this, request, response);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
}
