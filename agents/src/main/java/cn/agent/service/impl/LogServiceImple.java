package cn.agent.service.impl;

import cn.agent.pojo.Log;
import cn.agent.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class LogServiceImple implements LogService {


    @Override
    public
    boolean insertLog(Log log) {
        return false;
    }

    @Override
    public
    List<Log> findAllLog(Log log) {
        return null;
    }

    @Override
    public
    List<Log> findPageLog(Log log, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Log log) {
        return null;
    }
}
