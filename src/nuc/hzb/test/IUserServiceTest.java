package nuc.hzb.test;

import nuc.hzb.entity.User;
import nuc.hzb.service.IUserService;
import nuc.hzb.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author 黄朝博
 */
public class IUserServiceTest {

    IUserService iUserService = new UserServiceImpl();

    /**
     * 测试返回-1则证明存在该id,注册失败
     */
    @Test
    public void register() {
        Date date = new Date();
        System.out.println(iUserService.register(new User("admin", "admin", "admin", "admin", "男", "adimn@qq.com", date)));
    }

    /**
     * 返回User{id='huang', name='黄朝博', password='19990508', salt='test', sex='男', email='344728800@qq.com', date=2020-05-07}
     * 登录成功
     */
    @Test
    public void login() {
        System.out.println(iUserService.login("huang", "19990508"));

    }
}