package cn.agent.service.impl;

import cn.agent.pojo.Linkman;
import cn.agent.service.LinkmanService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class LinkmanServiceImple implements LinkmanService {


    @Override
    public
    boolean update(Linkman linkman) {
        return false;
    }

    @Override
    public
    boolean insert(Linkman linkman) {
        return false;
    }

    @Override
    public
    List<Linkman> findAllLinkman(Linkman linkman) {
        return null;
    }

    @Override
    public
    Page<Linkman> findPageLinkman(Linkman linkman, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Linkman linkman) {
        return null;
    }

    @Override
    public
    Linkman findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Linkman linkman) {
        return false;
    }
}
