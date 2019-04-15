package cn.agent.service.impl;

import cn.agent.pojo.Jurisdiction;
import cn.agent.service.JurisdictionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class JurisdictionServiceImple implements JurisdictionService {


    @Override
    public
    boolean update(Jurisdiction jurisdiction) {
        return false;
    }

    @Override
    public
    boolean insert(Jurisdiction jurisdiction) {
        return false;
    }

    @Override
    public
    List<Jurisdiction> findAllJurisdiction(Jurisdiction jurisdiction) {
        return null;
    }

    @Override
    public
    Page<Jurisdiction> findPageJurisdiction(Jurisdiction jurisdiction, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Jurisdiction jurisdiction) {
        return null;
    }

    @Override
    public
    Jurisdiction findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Jurisdiction jurisdiction) {
        return false;
    }
}
