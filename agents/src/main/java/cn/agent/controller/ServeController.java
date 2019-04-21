package cn.agent.controller;

import cn.agent.pojo.Types;
import cn.agent.service.TypesService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 服务类型
 */
@Controller
@RequestMapping(value = "/serve")
public class ServeController {
    @Autowired
    private TypesService typesService;
    /**
     *查询服务类型信息
     * @return
     */
    @RequestMapping(value = "/financeType.json")
    @ResponseBody
    public List<Types> findTypes(@Param("typeParentId") Long typeParentId){
        List<Types> list=typesService.findTypesByParentid(typeParentId);
      /*  System.out.println(JSON.toJSONString(list,true));*/
        return list;
    }
}
