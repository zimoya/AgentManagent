package cn.agent.service.impl;

import cn.agent.dao.KeywordDao;
import cn.agent.pojo.Keyword;
import cn.agent.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordDao keywordDao;
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
    Page<Keyword> findPageKeyword(String kwname, int pageSum) {
        Pageable pageable = PageRequest.of( pageSum==0?1:pageSum,5 );
        Page<Keyword> keywords=null;
        //参数是否为空
        if(kwname==null && kwname.length()<=0){ //没有条件限制
            keywords=keywordDao.findAll(pageable);
        }else{
            keywords=keywordDao.findByKwnamePage( kwname ,pageable);
        }
        return keywords;
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
