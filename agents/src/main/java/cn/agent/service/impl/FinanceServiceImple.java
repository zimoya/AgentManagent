package cn.agent.service.impl;

import cn.agent.pojo.Finance;
import cn.agent.service.FinanceService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class FinanceServiceImple implements FinanceService {


    @Override
    public
    boolean update(Finance finance) {
        return false;
    }

    @Override
    public
    boolean insert(Finance finance) {
        return false;
    }

    @Override
    public
    List<Finance> findAllFinance(Finance finance) {
        return null;
    }

    @Override
    public
    Page<Finance> findPageFinance(Finance finance, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Finance finance) {
        return null;
    }

    @Override
    public
    Finance findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Finance finance) {
        return false;
    }
}
