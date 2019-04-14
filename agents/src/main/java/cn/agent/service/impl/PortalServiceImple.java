package cn.agent.service.impl;

import cn.agent.pojo.Portal;
import cn.agent.service.PortalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class PortalServiceImple implements PortalService {


    @Override
    public
    boolean update(Portal portal) {
        return false;
    }

    @Override
    public
    boolean insert(Portal portal) {
        return false;
    }

    @Override
    public
    List<Portal> findAllPortal(Portal portal) {
        return null;
    }

    @Override
    public
    List<Portal> findPagePortal(Portal portal, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Portal portal) {
        return null;
    }

    @Override
    public
    Portal findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Portal portal) {
        return false;
    }
}
