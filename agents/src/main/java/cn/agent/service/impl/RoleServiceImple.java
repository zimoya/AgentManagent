package cn.agent.service.impl;

import cn.agent.pojo.Role;
import cn.agent.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class RoleServiceImple implements RoleService {


    @Override
    public
    boolean update(Role role) {
        return false;
    }

    @Override
    public
    boolean insert(Role role) {
        return false;
    }

    @Override
    public
    List<Role> findAllRole(Role role) {
        return null;
    }

    @Override
    public
    Page<Role> findPageRole(Role role, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Role role) {
        return null;
    }

    @Override
    public
    Role findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Role role) {
        return false;
    }
}
