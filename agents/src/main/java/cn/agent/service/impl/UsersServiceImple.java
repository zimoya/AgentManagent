package cn.agent.service.impl;

import cn.agent.dao.UsersDao;
import cn.agent.pojo.Users;
import cn.agent.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class UsersServiceImple implements UsersService {
    /**
     * 创建dao层对象
     */
    @Autowired
    private UsersDao usersDao;

    /**
     * 修改用户信息
     * @param users 条件
     * @return
     */
    @Override
    public
    boolean update(Users users) {
        Users user=usersDao.save(users);
        if(users.getPassword()==user.getPassword()||users.getPassword().equals(user.getPassword())){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public
    boolean insert(Users users) {
        return false;
    }

    @Override
    public
    List<Users> findAllUsers(Users users) {
        return null;
    }

    @Override
    public Page<Users> findPageUsers(Users users, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Users users) {
        return null;
    }

    /**
     * 根据id查询用户信息
     * @param id 条件
     * @return
     */
    @Override
    public
    Users findById(Long id) {
        return usersDao.getOne(id);
    }

    @Override
    public
    boolean delete(Users users) {
        return false;
    }

    /**
     * 根据用户名查询用户信息，实现登录功能
     * @param username
     * @return
     */
    @Override
    public Users findUsersByUsername(String username) {
        return usersDao.findUsersByUsername(username);
    }

}
