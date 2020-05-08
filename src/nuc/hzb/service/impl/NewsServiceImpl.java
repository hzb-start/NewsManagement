package nuc.hzb.service.impl;

import nuc.hzb.dao.INewsDao;
import nuc.hzb.dao.impl.NewsDaoImpl;
import nuc.hzb.entity.News;
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
}
