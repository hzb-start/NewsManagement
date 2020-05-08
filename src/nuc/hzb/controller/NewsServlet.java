package nuc.hzb.controller;

import nuc.hzb.entity.News;
import nuc.hzb.service.INewsService;
import nuc.hzb.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 黄朝博
 */
@WebServlet(value = "/NewsServlet")
public class NewsServlet extends BaseServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void queryAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> newsList = iNewsService.queryAllNews();
        System.out.println("!!!!!!!!");
        request.setAttribute("newsList", newsList);
        request.getRequestDispatcher("new_manager.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
