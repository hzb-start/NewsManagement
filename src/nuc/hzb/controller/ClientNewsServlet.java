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

/**
 * @author 黄朝博
 */
public class ClientNewsServlet extends BaseServlet {

    private INewsService iNewsService = new NewsServiceImpl();


    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Page<News> page = iNewsService.page(pageNo, Page.PAGE_SIZE);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }


    protected void pageByTitle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        String title = request.getParameter("title");
        Page<News> page = iNewsService.pageByTitle(pageNo, Page.PAGE_SIZE, title);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

}
