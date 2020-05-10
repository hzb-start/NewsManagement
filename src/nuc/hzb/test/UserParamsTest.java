package nuc.hzb.test;

import nuc.hzb.entity.News;
import nuc.hzb.entity.User;
import org.junit.Test;

import java.util.Date;

/**
 * @author 黄朝博
 */
public class UserParamsTest {

    @Test
    public void params() {
        News news = new News("title", "author", "content");
        news.setHot(18);
        news.setId(10);
        news.setEnterdate(new Date());
        System.out.println(news);
    }
}
