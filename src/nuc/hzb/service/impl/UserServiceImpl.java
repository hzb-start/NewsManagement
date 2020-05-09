package nuc.hzb.service.impl;

import nuc.hzb.dao.IUserDao;
import nuc.hzb.dao.impl.UserDaoImpl;
import nuc.hzb.entity.User;
import nuc.hzb.service.IUserService;

/**
 * @author 黄朝博
 */
public class UserServiceImpl implements IUserService {

    private IUserDao iUserDao = new UserDaoImpl();


    @Override
    public int register(User user) {
        if (iUserDao.queryUserById(user.getId())) {
            return -1;
        } else {
            return iUserDao.addUser(user);
        }
    }


    @Override
    public User login(String id, String password) {
        return iUserDao.queryUserByIdAndPassword(id, password);
    }


    @Override
    public String querySalt(String id) {
        return iUserDao.querySaltById(id);
    }
}
