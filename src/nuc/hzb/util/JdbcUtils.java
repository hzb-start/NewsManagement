package nuc.hzb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 在方法中的变量命名，遵循全拼的规则，而传入的参数是缩写形式
 * @author 黄朝博
 */
public class JdbcUtils {
    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    /**
     * 获取数据库连接
     * @return 若返回为null则获取失败
     */
    public static Connection getConnection() {
        InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            String driver = properties.getProperty("DRIVER");
            String url = properties.getProperty("URL");
            String username = properties.getProperty("USERNAME");
            String password = properties.getProperty("PASSWORD");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭资源
     * @param rs 传入ResultSet
     * @param s 传入Statement以及子类
     * @param conn 传入Connection
     */
    public static void closeAll(ResultSet rs, Statement s, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (s != null) {
                s.close();
            }
            if (conn != null) {
                conn.close();
//                经测试不需要赋值为null，就可以关闭连接
//                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sql
     * @param params
     * @return
     */
    public static PreparedStatement getPreparedStatement(String sql, Object... params) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i+1, params[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }


    /**
     *
     * @return
     */
    public static Statement getStatement() {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    /**
     *
     * @param sql
     * @param params
     * @return 若返回-1或0则表示失败
     * 返回0是正常执行，但是不符合条件
     * 返回-1是错误，并没有执行 n = preparedStatement.executeUpdate();
     */
    public static int executeUpdate(String sql, Object... params) {
        int n = -1;
        preparedStatement = getPreparedStatement(sql, params);
        try {
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, preparedStatement, connection);
        }
        return n;
    }

    /**
     *
     * @param sql
     * @param params
     * @return 若返回为null则表示没有该结果集
     */
    public static ResultSet executeQuery(String sql, Object... params) {
    /*    确保resultSet变量为null
        System.out.println("resultSet是：" + resultSet);*/
        resultSet = null;
        preparedStatement = getPreparedStatement(sql, params);
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
