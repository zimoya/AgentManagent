package cn.agent.service.impl;

import cn.agent.pojo.Keyword;
import cn.agent.service.KeywordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class KeywordServiceImple implements KeywordService {


    @Override
    public
    boolean update(Keyword keyword) {
        return false;
    }

    @Override
    public
    boolean insert(Keyword keyword) {
        return false;
    }

    @Override
    public
    List<Keyword> findAllKeyword(Keyword keyword) {
        return null;
    }

    @Override
    public
    List<Keyword> findPageKeyword(Keyword keyword, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Keyword keyword) {
        return null;
    }

    @Override
    public
    Keyword findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Keyword keyword) {
        return false;
    }
}