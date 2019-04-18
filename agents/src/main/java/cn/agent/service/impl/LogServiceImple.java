package cn.agent.service.impl;

import cn.agent.dao.LogDao;
import cn.agent.pojo.Log;
import cn.agent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public
class LogServiceImple implements LogService {

    //创建dao层对象
    @Autowired
    private LogDao logDao;

    /**
     * 添加日志
     * @param log 要填加的日志对象
     * @return
     */
    @Override
    public
    boolean insertLog(Log log) {
        Log log1=logDao.save(log);
        if(log1!=null || !log1.equals("")){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public
    List<Log> findAllLog(Log log) {
        return null;
    }

    @Override
    public
    Page<Log> findPageLog(Log log, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Log log) {
        return null;
    }
}
