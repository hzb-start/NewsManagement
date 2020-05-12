package nuc.hzb.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * @author 黄朝博
 */
public class PasswordTest {

    @Test
    public void sha256Hex() {
        String password = "huang";
        // 项目中使用UUID.randomUUID().toString()随机生成固定盐，存放到数据库中
        String random = UUID.randomUUID().toString();
        String salt = "19990508";
        String s = password + salt;
        System.out.println("随机盐：" + random);
        System.out.println("密码加盐后的字符串为：" + s);
        String sha256Hex = DigestUtils.sha256Hex(s);
        System.out.println("加密后的字符串为：" + sha256Hex);
    }

    @Test
    public void md5() {
        String password = "huang";
        // 项目中使用UUID.randomUUID().toString()随机生成固定盐，存放到数据库中
        String random = UUID.randomUUID().toString();
        String salt = "19990508";
        String s = password + salt;
        System.out.println("随机盐：" + random);
        System.out.println("密码加盐后的字符串为：" + s);
        String md5Hex = DigestUtils.md5Hex(s);
        System.out.println("加密后的字符串为：" + md5Hex);
    }

    @Test
    public void password() {
        String password = "huang";
        String salt = "19990508";
        String s = password + salt;
        String sha256Hex = DigestUtils.sha256Hex(s);
        String toUpperCase = sha256Hex.toUpperCase();
        String md5Hex = DigestUtils.md5Hex(toUpperCase);

        System.out.println(s);
        System.out.println(sha256Hex);
        System.out.println(toUpperCase);
        System.out.println(md5Hex);
    }
}
