package cn.agent.service.impl;

import cn.agent.pojo.Appaddress;
import cn.agent.service.AppaddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class AppaddressServiceImple implements AppaddressService {


    @Override
    public
    boolean update(Appaddress appaddress) {
        return false;
    }

    @Override
    public
    boolean insert(Appaddress appaddress) {
        return false;
    }

    @Override
    public
    List<Appaddress> findAllAppaddress(Appaddress appaddress) {
        return null;
    }

    @Override
    public
    List<Appaddress> findPageAppaddress(Appaddress appaddress, int pageSum) {
        return null;
    }

    @Override
    public
    Appaddress findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Appaddress appaddress) {
        return false;
    }
}
