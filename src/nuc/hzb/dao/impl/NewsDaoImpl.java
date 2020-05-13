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
    public List<News> queryAllNews() {
        // 由于返回值为List集合所以，news设置为null，会被警告为没有使用该值
        News news = null;
        List<News> newsList = new ArrayList<>();
        String sql = "select * from t_news";
        ResultSet resultSet = JdbcUtils.executeQuery(sql);
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


    @Override
    public News queryNewsById(int id) {
        News news = null;
        String sql = "select * from t_news where id = ?";
        Object[] params = {id};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
        // 单个查询用if判断即可，如果查询所有值将用while
        // 但是为了能将相同的代码整合，这个可以使用while
        try {
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
    public Integer queryForPageTotalCount() {
        Integer count = null;
        String sql = "select count(*) from t_news";
        ResultSet resultSet = JdbcUtils.executeQuery(sql);
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return count;
    }

    @Override
    public List<News> queryForPageItems(int begin, int pageSize) {
        News news = null;
        List<News> newsList = new ArrayList<>();
        String sql = "select * from t_news limit ?, ?";
        Object[] params = {begin, pageSize};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
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

    @Override
    public Integer queryForPageTotalCountByTitle(String title) {
        Integer count = null;
        String sql = "select count(*) from t_news where title like ?";
        Object[] params = {"%"+title+"%"};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return count;
    }

    @Override
    public List<News> queryForPageItemsByTitle(int begin, int pageSize, String title) {
        News news = null;
        List<News> newsList = new ArrayList<>();
        String sql = "select * from t_news where title like ? limit ?, ?";
        Object[] params = {"%"+title+"%", begin, pageSize};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
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