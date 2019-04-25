package cn.agent.controller;

import cn.agent.pojo.Client;
import cn.agent.pojo.Log;
import cn.agent.pojo.Role;
import cn.agent.pojo.Users;
import cn.agent.service.LogService;
import cn.agent.service.RoleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

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
     *
     * @param session
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/insert.do", "create", "add", "insert"})
    public
    Object insert(HttpSession session, Role role) {
        role.setCreatetime( new Date() );
        role.setExiststatus( 0l );
        //参数监测
        Role result = roleService.insert( role );
        logService.insertLog( new Log( (Users) session.getAttribute( "user" ), "添加角色:" + result.getRolename(), new Date() ) );
        return JSON.parseObject( "{\"insertResult\":" + JSON.toJSONString( result ) + ",\"exeCode\":\"0\",\"message\":\"添加成功\"}" );
    }

    /**
     * 更新
     *
     * @param session
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/update.do", "update"})
    public
    Object update(HttpSession session, Role role) {
        Role role2 = roleService.findById( role.getRoleid() );
        role.setCreatetime( role2.getCreatetime() );
        role.setExiststatus( role2.getExiststatus() );
        //参数监测
        Role result = roleService.update( role );
        logService.insertLog( new Log( (Users) session.getAttribute( "user" ), "修改角色:" + role.getRolename(), new Date() ) );
        return JSON.parseObject( "{\"updateResult\":" + JSON.toJSONString( result ) + ",\"exeCode\":\"0\",\"message\":\"修改成功\"}" );
    }

    /**
     * 删除
     *
     * @param session
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/delete.do", "/delete", "delById"})

    public
    Object delete(HttpSession session, Role role) {
        //参数监测
        try {
            boolean result = roleService.delete( role );
            logService.insertLog( new Log( (Users) session.getAttribute( "user" ), "删除角色:" + role.getRoleid(), new Date() ) );
            return JSON.parseObject( "{\"message\":\"删除成功\",\"deleteResult\":\"" + result + "\",\"exeCode\":\"0\",\"roleid\":\"" + role.getRoleid() + "\"}" );

        } catch (Exception e) {
            e.printStackTrace();
            return JSON.parseObject( "{\"message\":\"该角色正在使用中,无法删除....~~>_<~~\",\"deleteResult\":\"" + false + "\",\"exeCode\":\"0\",\"roleid\":\"0\"}" );

        }
    }


    /**
     * /查询所有的角色信息
     *
     * @return
     */
    @RequestMapping(value = "bindrole")
    @ResponseBody
    public
    Object FindAllRoleInfo() {
        List<Role> role = roleService.findAllRoleInfo();
        return JSONArray.toJSONString( role );
    }

    @RequestMapping(value = {"readPageRoleData", "readPage"})
    @ResponseBody
    public
    Object readPageRoleData(int indexPage) {
        Page<Role> roles = roleService.findPageRole( null, indexPage );
        return JSON.parseObject( "{\"exeCode\":\"0\",\"message\":\"获取数据成功\",\"data\":" + JSON.toJSONString( roles ) + "}" );
    }

    @RequestMapping(value = {"readOne", "findRoleByRoleid"})
    @ResponseBody
    public
    Object findRoleByRoleid(Long roleid) {
        Role role = roleService.findById( roleid );
        return JSON.parseObject( "{\"exeCode\":\"0\",\"message\":\"获取数据成功\",\"data\":" + JSON.toJSONString( role ) + "}" );
    }
}
