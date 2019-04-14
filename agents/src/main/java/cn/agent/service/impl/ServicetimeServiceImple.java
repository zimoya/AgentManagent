package cn.agent.service.impl;

import cn.agent.pojo.Servicetime;
import cn.agent.service.ServicetimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ServicetimeServiceImple implements ServicetimeService {


    @Override
    public
    boolean update(Servicetime servicetime) {
        return false;
    }

    @Override
    public
    boolean insert(Servicetime servicetime) {
        return false;
    }

    @Override
    public
    List<Servicetime> findAllServicetime(Servicetime servicetime) {
        return null;
    }

    @Override
    public
    List<Servicetime> findPageServicetime(Servicetime servicetime, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Servicetime servicetime) {
        return null;
    }

    @Override
    public
    Servicetime findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Servicetime servicetime) {
        return false;
    }
}
