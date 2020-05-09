package nuc.hzb.dao;

import nuc.hzb.entity.User;

/**
 * @author 黄朝博
 */
public interface IUserDao {


    /**
     * ss
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * ss
     * @param id
     * @param password
     * @return
     */
    User queryUserByIdAndPassword(String id, String password);

    /**
     * 11
     * @param id
     * @return
     */
    boolean queryUserById(String id);


    /**
     * 通过用户id查看用户盐值
     * @param id
     * @return
     */
    String querySaltById(String id);


}
