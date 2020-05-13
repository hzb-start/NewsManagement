package nuc.hzb.dao;

import nuc.hzb.entity.News;

import java.util.List;

/**
 * @author 黄朝博
 */
public interface INewsDao {

    /**
     * 增加新闻
     * @param news
     * @return 成功为1，失败为0或-1
     */
    int addNews(News news);


    /**
     * 通过id进行删除
     * @param id
     * @return
     */
    int deleteNewsById(int id);


    /**
     * 不指定用id来改，将来可以进行一定的扩充
     * @param news
     * @return
     */
    int updateNews(News news);



    /**
     * 查询所有新闻
     * @return 集合的形式返回
     */
    List<News> queryAllNews();


    /**
     * 通过id查询单条新闻详情
     * @param id
     * @return
     */
    News queryNewsById(int id);


    Integer queryForPageTotalCount();

    List<News> queryForPageItems(int begin, int pageSize);




    Integer queryForPageTotalCountByTitle(String title);

    List<News> queryForPageItemsByTitle(int begin, int pageSize, String title);
}
