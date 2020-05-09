package nuc.hzb.test;

import nuc.hzb.entity.News;
import nuc.hzb.service.INewsService;
import nuc.hzb.service.impl.NewsServiceImpl;
import org.junit.Test;

import java.util.Date;



/**
 * @author 黄朝博
 */
public class INewsServiceTest {

    INewsService iNewsService = new NewsServiceImpl();


    /**
     * 成功返回1
     * 失败返回0
     */
    @Test
    public void addNews() {
        System.out.println(iNewsService.addNews(new News(0, "test111", "黄朝博", "内容", new Date(), 12, null)));
    }


    /**
     * 成功返回1
     * 失败返回0
     */
    @Test
    public void deleteNewsById() {
        System.out.println(iNewsService.deleteNewsById(38));
    }


    /**
     * 成功返回1
     * 失败返回0
     */
    @Test
    public void updateNews() {
        System.out.println(iNewsService.updateNews(new News(36, "test户数还是", "黄朝博", "内容", new Date(), 12, null)));
    }


    /**
     * 成功返回news对象
     * 失败返回null
     */
    @Test
    public void queryNewsById() {
        System.out.println(iNewsService.queryNewsById(40));
    }


    /**
     * 成功返回news对象数组
     * 失败返回空数组
     */
    @Test
    public void queryAllNews() {
        System.out.println(iNewsService.queryAllNews());
    }
}