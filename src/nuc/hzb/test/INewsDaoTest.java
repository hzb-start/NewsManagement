package nuc.hzb.test;

import nuc.hzb.dao.INewsDao;
import nuc.hzb.dao.impl.NewsDaoImpl;
import nuc.hzb.entity.News;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author 黄朝博
 */
public class INewsDaoTest {

    private INewsDao iNewsDao = new NewsDaoImpl();

    /**
     * 在验证的时候，把id的值默认为0，实际在录入数据的时候，系统会默认自增录取
     * 由于没有缺省id的构造方法，所以之后的处理同样，将id值为0，交由系统处理
     */
    @Test
    public void addNews() {
        Date date = new Date();
        int i = iNewsDao.addNews(new News(0, "test", "黄朝博", "内容", date, 12, null));
        if (i != -1) {
            System.out.println("增加成功!");
        } else {
            System.out.println("增加失败!");
        }
    }

    /**
     * 返回集合形式，测试成功
     */
    @Test
    public void queryAllNews() {
        List<News> newsList = iNewsDao.queryAllNews();
        System.out.println(newsList);
    }

    /**
     * 如果i为-1则表示存在异常
     * 如果i为0则表示不存在该值
     * 如果i为1则表示删除成功
     */
    @Test
    public void deleteNewsById() {
        int i = iNewsDao.deleteNewsById(8);
        System.out.println(i);
    }

    /**
     * 如果返回值为null则不存在该id
     * 如果返回值为news对象则存在该id
     */
    @Test
    public void queryNewsById() {
        News news = iNewsDao.queryNewsById(35);
        System.out.println(news);
    }


    @Test
    public void queryForPageTotalCount() {
        Integer integer = iNewsDao.queryForPageTotalCount();
        System.out.println(integer);
    }


    /**
     * begin 0 1 2 ... 开始
     * 对应于数据库的第1 2 3条记录
     */
    @Test
    public void queryForPageItems() {
        List<News> newsList = iNewsDao.queryForPageItems(0, 3);
        for (News news : newsList) {
            System.out.println(news);
        }
    }

}