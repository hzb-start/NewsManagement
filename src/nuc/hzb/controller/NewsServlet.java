package nuc.hzb.controller;

import nuc.hzb.entity.News;
import nuc.hzb.service.INewsService;
import nuc.hzb.service.impl.NewsServiceImpl;
import nuc.hzb.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * @author 黄朝博
 */
public class NewsServlet extends BaseServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    protected void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        News news = WebUtils.copyParamToBean(request.getParameterMap(), new News());
        // 处理前台没有让管理员输入的日期、热度
        news.setEnterdate(new Date());
        news.setHot(0);
        iNewsService.addNews(news);
        response.sendRedirect("newsServlet?action=queryAllNews");
    }


    protected void deleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        iNewsService.updateNews()
    }


    protected void queryAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> newsList = iNewsService.queryAllNews();
        request.setAttribute("newsList", newsList);
        request.getRequestDispatcher("/pages/manager/new_manager.jsp").forward(request, response);
    }
}
