package cn.agent.controller;

import cn.agent.pojo.Log;
import cn.agent.pojo.Types;
import cn.agent.pojo.Users;
import cn.agent.service.LogService;
import cn.agent.service.TypesService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * 财务管理
 */
@Controller
@RequestMapping(value = "/finance")
public class FinanceController {

    @Autowired
    private TypesService typesService;
    @Autowired
    private LogService logService;//日志
    /**
     *查询财务类型信息
     * @return
     */
    @RequestMapping(value = "/financeType.json")
    @ResponseBody
    public List<Types> findTypes(@Param("typeParentId") Long typeParentId, HttpSession session){
        List<Types> list=typesService.findTypesByParentid(typeParentId);
      /*  System.out.println(JSON.toJSONString(list,true));*/
        Users user=(Users) session.getAttribute("user");
        Log log=new Log();
        log.setUsers(user);
        log.setLoginfo("查看财务类型");
        log.setLogtime(new Date());
        logService.insertLog(log);
        return list;
    }

    /**
     * 添加服务类型
     * @param typeName
     * @param status
     * @param session
     * @return
     */
    @RequestMapping(value="/saveFinaceType.do")
    @ResponseBody
    public boolean  saveFindTypes(@RequestParam String typeName,@RequestParam  Long status, HttpSession session){
        System.out.println("财务类型================================================>");
        System.out.println("status======================================================>"+typeName);
        System.out.println("status======================================================>"+status);
       Long parent=27l;
        Types types=new Types();
       types.setParentid(parent);
       types.setTypename(typeName);
       types.setStatus(status);
       types.setExist(0l);
       boolean  find= typesService.insert(types);
       if(find==true){
           Users user=(Users) session.getAttribute("user");
           Log log=new Log();
           log.setUsers(user);
           log.setLoginfo("成功添加财务类型");
           log.setLogtime(new Date());
           logService.insertLog(log);
       }else{
           Users user=(Users) session.getAttribute("user");
           Log log=new Log();
           log.setUsers(user);
           log.setLoginfo("添加财务类型发生延迟");
           log.setLogtime(new Date());
           logService.insertLog(log);
       }
        return find;
    }

    /**
     * 修改服务类型
     * @param typeName
     * @param status
     * @param session
     * @return
     */
    @RequestMapping(value="/saveFinaceType.up")
    @ResponseBody
    public boolean  upFindTypes(@RequestParam String typeName,@RequestParam  Long status,@RequestParam Long typeId, HttpSession session){
        System.out.println("财务类型================================================>");
        System.out.println("status======================================================>"+typeName);
        System.out.println("status======================================================>"+status);
        Long parent=27l;
        Types types=new Types();
        types.setTypeid(typeId);
        types.setParentid(parent);
        types.setTypename(typeName);
        types.setStatus(status);
        types.setExist(0l);
        boolean  find= typesService.update(types);
        if(find==true){
            Users user=(Users) session.getAttribute("user");
            Log log=new Log();
            log.setUsers(user);
            log.setLoginfo("成功修改财务类型");
            log.setLogtime(new Date());
            logService.insertLog(log);
        }else{
            Users user=(Users) session.getAttribute("user");
            Log log=new Log();
            log.setUsers(user);
            log.setLoginfo("修改财务类型发生延迟");
            log.setLogtime(new Date());
            logService.insertLog(log);
        }
        return find;
    }
}
