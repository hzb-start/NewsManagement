package nuc.hzb.controller;

import nuc.hzb.entity.News;
import nuc.hzb.entity.Page;
import nuc.hzb.service.INewsService;
import nuc.hzb.service.impl.NewsServiceImpl;
import nuc.hzb.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 黄朝博
 */
public class NewsServlet extends BaseServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数pageNo、pageSize


        // 1获取请求的参数 pageNo 和 pageSize
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
//        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2调用NewsService.page(pageNo，pageSize)：Page对象
        Page<News> page = iNewsService.page(pageNo, Page.PAGE_SIZE);

//        page.setUrl("manager/newsServlet?action=page");

//         3保存Page对象到Request域中
        request.setAttribute("page",page);
        // 4请求转发到pages/manager/news_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/new_manager.jsp").forward(request, response);

    }

    protected void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        News news = WebUtils.populateParams(request.getParameterMap(), new News());
        // 处理前台没有让管理员输入的日期、热度
        // id交由数据库处理
        news.setEnterdate(new Date());
        news.setHot(0);
        iNewsService.addNews(news);
        response.sendRedirect(request.getContextPath() + "/manager/newsServlet?action=page&pageNo=" + request.getParameter("pageNo") + 1);
    }


    protected void deleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        iNewsService.deleteNewsById(id);
        response.sendRedirect(request.getContextPath() + "/manager/newsServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }


    protected void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 需要一个这样的业务：
         * 表单回传过来的新闻，是不含id，enterdate，hot这三个字段
         * 所以使用WebUtils进行填充的news是缺失数据的
         * 想办法，将缺失的三个数据找回，即可完成修改
         * 使用隐藏域
         *
         */
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter writer = response.getWriter();
//        writer.write("修改功能，正在维护！");
//
//        这段代码写的是相当糟糕！
//        服务器压力会很大的

        News updateNews = WebUtils.populateParams(request.getParameterMap(), new News());
        News news = iNewsService.queryNewsById(updateNews.getId());
        news.setTitle(updateNews.getTitle());
        news.setAuthor(updateNews.getAuthor());
        news.setContent(updateNews.getContent());
        iNewsService.updateNews(news);
        response.sendRedirect(request.getContextPath() + "/manager/newsServlet?action=page&pageNo=" + request.getParameter("pageNo"));

//        News news = WebUtils.populateParams(request.getParameterMap(), new News());
//        iNewsService.updateNews(news);
//        response.sendRedirect(request.getContextPath() + "/manager/newsServlet?action=queryAllNews");


    }


    protected void queryNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先完成回显数据
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        News news = iNewsService.queryNewsById(id);
        request.setAttribute("news", news);
        request.getRequestDispatcher("/pages/manager/news_edit.jsp").forward(request, response);
    }


    protected void queryAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> newsList = iNewsService.queryAllNews();
        request.setAttribute("newsList", newsList);
        request.getRequestDispatcher("/pages/manager/new_manager.jsp").forward(request, response);
    }
}
