package cn.agent.controller;

import cn.agent.pojo.Client;
import cn.agent.pojo.Log;
import cn.agent.pojo.Role;
import cn.agent.pojo.Users;
import cn.agent.service.LogService;
import cn.agent.service.RoleService;
import com.alibaba.fastjson.JSON;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "/role")
public
class RoleController {
    //添加 删除 更改
    @Autowired
    private
    LogService logService;
    @Autowired
    private
    RoleService roleService;

    /**
     * 添加
     * @param session
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert.do")
    public
    Object insert(HttpSession session, Role role) {
        //参数监测
        Role result = roleService.insert( role );
        logService.insertLog( new Log( (Users) session.getAttribute( "user" ), "添加角色:"+result.getRolename(), new Date() ) );
        return JSON.parseObject( "{\"insertResult\":" + JSON.toJSONString( result )  + "}" );
    }

    /**
     * 更新
     * @param session
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/update.do")
    public
    Object update(HttpSession session, Role role) {
        //参数监测
        Role result = roleService.update( role );
        logService.insertLog( new Log( (Users) session.getAttribute( "user" ), "修改角色:"+role.getRolename(), new Date() ) );
        return JSON.parseObject( "{\"updateResult\":" + JSON.toJSONString( result )  + "}" );
    }

    /**
     * 删除
     * @param session
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete.do")
    public
    Object delete(HttpSession session, Role role) {
        //参数监测
        boolean result = roleService.delete( role );
        logService.insertLog( new Log( (Users) session.getAttribute( "user" ), "删除角色:"+role.getRoleid(), new Date() ) );
        return JSON.parseObject( "{\"deleteResult\":\"" + result + "\"}" );
    }


}
