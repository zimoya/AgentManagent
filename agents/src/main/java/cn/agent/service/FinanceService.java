package cn.agent.service;

import cn.agent.pojo.Finance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
interface FinanceService {
    /**
     * 修改财务明细
     *
     * @param finance 条件
     * @return 是否修改成功
     */
    boolean update(Finance finance);

    /**
     * 添加财务明细
     *
     * @param finance 条件
     * @return 是否添加成功
     */
    boolean insert(Finance finance);

    /**
     * 根据条件获取满足条件的财务明细
     *
     * @param finance 条件
     * @return 财务明细list
     */
    List<Finance> findAllFinance(Finance finance);

    /**
     * 根据条件获取指定页数的财务明细对象
     * @param finance 财务明细条件
     * @param pageSum 页数
     * @return 财务明细list
     */
    List<Finance> findPageFinance(Finance finance,int pageSum);

    /**
     * 获取满足条件的记录数
     * @param finance 条件  条件为null时获取所有
     * @return 记录个数
     */
    Long getCount(Finance finance);
    /**
     * 根据id查询财务明细
     *
     * @param id 条件
     * @return 财务明细
     */
    Finance findById(Long id);

    /**
     * 删除财务明细
     *
     * @param finance 条件
     * @return 是否删除成功
     */
    boolean delete(Finance finance);

}
