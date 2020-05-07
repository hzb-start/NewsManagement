package nuc.hzb.test;

import nuc.hzb.util.JdbcUtils;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 黄朝博
 * 测试可能出现的问题
 * 2020/5/6完成getConnection()、update()、query()相关的测试
 *
 *
 */
public class JdbcUtilsTest {

    /**
     * 测试数据库是否连接成功
     */
    @Test
    public void getConnection() {
        System.out.println(JdbcUtils.getConnection());
    }

    /**
     * 测试增删改、测试是否执行完后关闭资源
     * 打印出如下语句，可看出已经关闭
     * com.mysql.jdbc.JDBC4Connection@612679d6
     * com.mysql.jdbc.JDBC42PreparedStatement@4d3167f4: EXCEPTION: java.sql.SQLException: No operations allowed after statement closed.
     *
     * 如果没有关闭将会出现下面的提示
     * com.mysql.jdbc.JDBC4Connection@eafc191
     * com.mysql.jdbc.JDBC42PreparedStatement@4d3167f4: insert into test values('hzb', '1999')
     *
     */
    @Test
    public void update() {
        String sql = "insert into test values(?, ?)";
        Object[] params = {"zb", "999"};
        int n = JdbcUtils.executeUpdate(sql, params);
        System.out.println(JdbcUtils.connection);
        System.out.println(JdbcUtils.preparedStatement);
        System.out.println(n);
    }

    /**
     * @date 2020/5/7 测试
     * 简单测试查询，ResultSet是否会关闭
     * 经测试出现下面情况
     * 查询是否成功：com.mysql.jdbc.JDBC42ResultSet@87f383f
     * zb:999
     * 是否关闭rs：com.mysql.jdbc.JDBC42ResultSet@87f383f
     * java.sql.SQLException: Operation not allowed after ResultSet closed
     *
     * 可见关闭成功，
     */
    @Test
    public void query() {
        ResultSet rs = null;
        String sql = "select * from test";
        rs = JdbcUtils.executeQuery(sql, null);
        System.out.println("查询是否成功：" + rs);
        String name = null;
        String password = null;
        try {
            while (rs.next()) {
                name = rs.getString("name");
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(name + ":" + password);
        name = null;
        password = null;
        JdbcUtils.closeAll(rs, JdbcUtils.preparedStatement, JdbcUtils.connection);
        System.out.println("是否关闭rs：" + rs);
        try {
            while (rs.next()) {
                name = rs.getString("name");
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(name + ":" +password);
    }
}
