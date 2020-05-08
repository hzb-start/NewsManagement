package nuc.hzb.dao.impl;

import nuc.hzb.dao.INewsDao;
import nuc.hzb.entity.News;
import nuc.hzb.util.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄朝博
 */
public class NewsDaoImpl implements INewsDao {

    @Override
    public int addNews(News news) {
        int n;
//        id自增
        String sql = "insert into t_news values (default, ?, ?, ?, ?, ?, ?)";
//        不带图片路径
//        String sql = "insert into t_news values (default, ?, ?, ?, ?, ?)";
        Object[] params = {news.getTitle(), news.getAuthor(), news.getContent(), news.getEnterdate(), news.getHot(), news.getImg_path()};
        n = JdbcUtils.executeUpdate(sql, params);
        return n;
    }


    @Override
    public int deleteNewsById(int id) {
        int n;
        String sql = "delete from t_news where id = ?";
        Object[] params = {id};
        n = JdbcUtils.executeUpdate(sql, params);
        return n;
    }


    @Override
    public int updateNews(News news) {
        int n;
        String sql = "update t_news set title = ?, author = ?, content = ? , enterdate = ?, hot = ?, img_path = ? where id = ?";
        Object[] params = {news.getTitle(), news.getAuthor(), news.getContent(), news.getEnterdate(), news.getHot(), news.getImg_path(), news.getId()};
        n = JdbcUtils.executeUpdate(sql, params);
        return n;
    }


    @Override
    public News queryNewsById(int id) {
        News news = null;
        String sql = "select * from t_news where id = ?";
        Object[] params = {id};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
        try {
            // 单个查询用if判断即可，如果查询所有值将用while
            if (resultSet.next()) {
                news = new News(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("content"),
                        resultSet.getDate("enterdate"),
                        resultSet.getInt("hot"),
                        resultSet.getString("img_path"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return news;
    }


    @Override
    public List<News> queryAllNews() {
        // 由于返回值为List集合所以，news设置为null，会被警告为没有使用该值
        News news = null;
        List<News> newsList = new ArrayList<>();
        String sql = "select * from t_news";
        ResultSet resultSet = JdbcUtils.executeQuery(sql, null);
        try {
            while (resultSet.next()) {
                news = new News(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("content"),
                        resultSet.getDate("enterdate"),
                        resultSet.getInt("hot"),
                        resultSet.getString("img_path"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return newsList;
    }
}