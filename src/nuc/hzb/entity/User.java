package nuc.hzb.entity;

import java.util.Date;

/**
 * @author 黄朝博
 */
public class User {
    // 登录id
    private String id;
    // 真实姓名
    private String name;
    private String password;
    // 盐值
    private String salt;
    private String sex;
    private String email;
    // 注册日期
    private Date date;

    public User() { }

    public User(String id, String name, String password, String salt, String sex, String email, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.sex = sex;
        this.email = email;
        this.date = date;
    }

    public User(String id, String name, String password, String sex, String email, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
