package cn.agent.service.impl;

import cn.agent.dao.TypesDao;
import cn.agent.pojo.Types;
import cn.agent.service.TypesService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class TypesServiceImple implements TypesService {

    @Override
    public
    boolean update(Types types) {
        return false;
    }

    @Override
    public
    boolean insert(Types types) {
        return false;
    }

    @Override
    public
    List<Types> findAllTypes(Types types) {
        return null;
    }

    @Override
    public
    Page<Types> findPageTypes(Types types, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Types types) {
        return null;
    }

    @Override
    public
    Types findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Types types) {
        return false;
    }
}
