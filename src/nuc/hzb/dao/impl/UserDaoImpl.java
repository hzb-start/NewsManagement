package nuc.hzb.dao.impl;

import com.sun.org.apache.xpath.internal.objects.XNull;
import nuc.hzb.dao.IUserDao;
import nuc.hzb.entity.User;
import nuc.hzb.util.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
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
