package nuc.hzb.test;

import nuc.hzb.dao.IUserDao;
import nuc.hzb.dao.impl.UserDaoImpl;
import nuc.hzb.entity.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author 黄朝博
 */
public class IUserDaoTest {

    /**
     * 在接口中Ctrl + Shift + t可生成测试类
     */
    private IUserDao iUserDao = new UserDaoImpl();

    /**
     * id如果重复会出现该异常
     * com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 'huang' for key 'PRIMARY'
     * 如果成功则显示：添加成功
     */
    @Test
    public void addUser() {
        Date date = new Date();
        int i = iUserDao.addUser(new User("admin", "admin", "admin", "admin", "男", "adimn@qq.com", date));
        if (i != -1) {
            System.out.println("增加成功");
        } else {
            System.out.println("增加失败");
        }
    }


    /**
     * 成功则显示
     * User{id='huang', name='黄朝博', password='19990508', salt='test', sex='男', email='344728800@qq.com', date=2020-05-07}
     */
    @Test
    public void queryUserByIdAndPassword() {
        System.out.println(iUserDao.queryUserByIdAndPassword("huang", "19990508"));
    }


    /**
     * 存在该id显示true，不存在则显示false
     */
    @Test
    public void queryUserById() {
        System.out.println(iUserDao.queryUserById("黄"));
    }


    @Test
    public void querySaltById() {
        System.out.println(iUserDao.querySaltById("huang"));

    }

}