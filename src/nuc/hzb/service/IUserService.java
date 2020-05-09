package nuc.hzb.service;

import nuc.hzb.entity.User;

/**
 * @author 黄朝博
 */
public interface IUserService {

    /**
     * 用户注册
     * @param user 将用户封装
     * @return 注册为一个，返回int值，如果成功返回1，如果失败返回-1
     */
    int register(User user);


    /**
     * 用户登录
     * @param id
     * @param password
     * @return
     */
    User login(String id, String password);


    /**
     * 通过id只查看用户的盐值
     * @param id
     * @return 如果存在id则返回该id的盐值，如果不存在返回null
     */
    String querySalt(String id);

}
