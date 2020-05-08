package nuc.hzb.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 黄朝博
 */
public class UserServletTest {

    public void login() {
        System.out.println("这是login方法");
    }

    public void register() {
        System.out.println("这是register方法");
    }

    public void updateUser() {
        System.out.println("这是更新用户信息的方法");
    }


    /**
     * 如果没有xxx方法则会出现以下异常：
     * java.lang.NoSuchMethodException: nuc.hzb.test.UserServletTest.xxx()
     * 如果又login方法则会出现以下情况：
     * public void nuc.hzb.test.UserServletTest.login()
     * @param args
     */
    public static void main(String[] args) {
        String login = "login";
        try {
            Method loginMethod = UserServletTest.class.getDeclaredMethod(login);
            System.out.println(loginMethod);
            loginMethod.invoke(new UserServletTest());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
