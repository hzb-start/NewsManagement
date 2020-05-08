package nuc.hzb.service;

import nuc.hzb.entity.News;

import java.util.List;

/**
 * @author 黄朝博
 */
public interface INewsService {


    /**
     * 增加新闻
     * @param news
     * @return
     */
    int addNews(News news);


    /**
     * 通过id删除新闻
     * @param id
     * @return
     */
    int deleteNewsById(int id);


    /**
     * 更新新闻
     * @param news
     * @return
     */
    int updateNews(News news);

    /**
     * 通过id查询单个新闻
     * @param id
     * @return
     */
    News queryNewsById(int id);


    /**
     * 查询所有新闻
     * @return
     */
    List<News> queryAllNews();

}
