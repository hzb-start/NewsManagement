package nuc.hzb.service.impl;

import nuc.hzb.dao.INewsDao;
import nuc.hzb.dao.impl.NewsDaoImpl;
import nuc.hzb.entity.News;
import nuc.hzb.entity.Page;
import nuc.hzb.service.INewsService;

import java.util.List;

/**
 * @author 黄朝博
 */
public class NewsServiceImpl implements INewsService {

    private INewsDao iNewsDao = new NewsDaoImpl();


    @Override
    public int addNews(News news) {
        return iNewsDao.addNews(news);
    }


    @Override
    public int deleteNewsById(int id) {
        return iNewsDao.deleteNewsById(id);
    }


    @Override
    public int updateNews(News news) {
        return iNewsDao.updateNews(news);
    }


    @Override
    public News queryNewsById(int id) {
        return iNewsDao.queryNewsById(id);
    }


    @Override
    public List<News> queryAllNews() {
        return iNewsDao.queryAllNews();
    }


    @Override
    public Page<News> page(int pageNo, int pageSize) {
        Page<News> page = new Page<>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = iNewsDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<News> items = iNewsDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<News> pageByTitle(int pageNo, int pageSize, String title) {
        Page<News> page = new Page<>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = iNewsDao.queryForPageTotalCountByTitle(title);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<News> items = iNewsDao.queryForPageItemsByTitle(begin, pageSize, title);
        page.setItems(items);
        return page;
    }
}
