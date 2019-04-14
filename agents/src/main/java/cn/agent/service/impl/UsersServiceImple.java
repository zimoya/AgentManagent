package cn.agent.service.impl;

import cn.agent.pojo.Users;
import cn.agent.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class UsersServiceImple implements UsersService {


    @Override
    public
    boolean update(Users users) {
        return false;
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
    public
    List<Users> findPageUsers(Users users, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Users users) {
        return null;
    }

    @Override
    public
    Users findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Users users) {
        return false;
    }
}
