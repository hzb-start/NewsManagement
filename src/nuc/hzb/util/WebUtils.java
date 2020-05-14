package nuc.hzb.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 黄朝博
 */
public class WebUtils {

    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     */
    public static <T> T populateParams(Map value , T bean) {
        try {
            System.out.println("填充之前：" + bean);
//            把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean, value);
            System.out.println("填充之后：" + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }


    /**
     * 将字符串转换成为int类型的数据
     * @param str
     * @param defaultValue
     * @return
     */
    public static int parseInt(String str, int defaultValue) {
        if (str != null) {
            return Integer.parseInt(str);
        } else {
            return defaultValue;
        }
    }


    /**
     * 加密用户真正输入的密码，真正的密码建议与随机字符串构成
     * 随机字符串也就是系统生成的用户salt
     * @param data 该项目中指的是realPassword用户真正的密码+salt
     * @return db_password 数据库中存放的密码（md5格式）
     */
    public static String encryptPassword(String data) {
        String db_password = null;
        String sha256Hex = DigestUtils.sha256Hex(data);
        String toUpperCase = sha256Hex.toUpperCase();
        String md5Hex = DigestUtils.md5Hex(toUpperCase);
        db_password = md5Hex;
        return db_password;
    }

}
