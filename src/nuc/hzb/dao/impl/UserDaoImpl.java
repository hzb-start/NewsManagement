package nuc.hzb.dao.impl;

import nuc.hzb.dao.IUserDao;
import nuc.hzb.entity.User;
import nuc.hzb.util.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现层必须注意一点：增删改不需要关闭PreparedStatement、Connection（在工具包中已经关闭）
 * 但是对于查询而言，由于在工具包中的返回值为ResultSet对象（确保对于所有实体类都可以使用）
 * 当返回ResultSet对象时，意味着不能关闭ResultSet、PreparedStatement、Connection三个对象
 * 如果关闭则获取不到ResultSet对象
 * 因此必须在具体的实现层去关闭
 * @author 黄朝博
 */
public class UserDaoImpl implements IUserDao {


    @Override
    public int addUser(User user) {
        int n = -1;
        String sql = "insert into t_user values (?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {user.getId(), user.getName(), user.getPassword(), user.getSalt(), user.getSex(), user.getEmail(), user.getDate()};
        n = JdbcUtils.executeUpdate(sql, params);
        return n;
    }


    @Override
    public User queryUserByIdAndPassword(String id, String password) {
        User user = null;
        String sql = "select * from t_user where id=? and password=?";
        Object[] params = {id, password};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
        try {
            // 单个查询，可用if判断语句
            if (resultSet.next()) {
                user = new User(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("salt"),
                        resultSet.getString("sex"),
                        resultSet.getString("email"),
                        resultSet.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return user;
    }

    /**
     * 通过id查看用户注册时候生成的salt
     * @param id 用户id
     * @return String，失败为null
     */
    @Override
    public String querySaltById(String id) {
        String salt = null;
        String sql = "select salt from t_user where id = ?";
        Object[] params = {id};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                salt = resultSet.getString("salt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return salt;
    }


    @Override
    public boolean queryUserById(String id) {
        String sql = "select * from t_user where id = ?";
        Object[] params = {id};
        ResultSet resultSet = JdbcUtils.executeQuery(sql, params);
        try {
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(resultSet, JdbcUtils.preparedStatement, JdbcUtils.connection);
        }
        return false;
    }
}
