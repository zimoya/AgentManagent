package cn.agent.service;

import cn.agent.pojo.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
interface LogService {

    /**
     * 添加一个操作日志
     * @param log 要填加的日志对象
     * @return 是否添加成功
     */
    boolean insertLog(Log log);

    /**
     * 分页查询符合条件的操作日志
     * @param pageable 分页参数 实现类PageRequest 创建方式public static PageRequest of(int page,int size) public static PageRequest of(int page,int size,Sort sort) public static PageRequest of(int page,int size,Direction direction,String ... properties)
     * @param log 条件
     * @return 符合条件的操作日志
     */
    List<Log> findLogByAll(Pageable pageable,Log log);

}
