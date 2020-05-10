package nuc.hzb.util;

import org.apache.commons.beanutils.BeanUtils;

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
            System.out.println("注入之前：" + bean);
//            把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
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
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

}
