package cn.agent.controller;

import cn.agent.pojo.Users;
import cn.agent.service.UsersService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    //创建service层对象
    @Autowired
    private UsersService usersService;
    //创建log4j
    private Logger logger=Logger.getLogger(UserController.class);

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping(value = "/login")
    public String Login(){
        return "";
    }

    /**
     * 实现用户登录
     * @return
     */
    @RequestMapping(value = "/doLogin.json")
    @ResponseBody
    public String doLogin(@Param("username") String username, @Param("password") String password, HttpSession session){
        logger.debug("===========================name"+username);
        logger.debug("===========================password"+password);
        //调用service层方法，根据用户名查询
        Users users=usersService.findUsersByUsername(username);
        String falg;
        if(users!=null){ //如果返回的对象不为空，则判断密码是否正确
            if(password==users.getPassword()||password.equals(users.getPassword())){ //如果密码正确，则将用户信息保存到session
                    session.setAttribute("user",users);
                    Users user=(Users) session.getAttribute("user");
                    System.out.println(user.getUsername());
                    falg="success";
            }else{
                falg="error";
            }
        }else{ //如果返回对象为空，则用户名不正确
            falg="failed";
        }
            return JSON.toJSONString(falg);
    }

    /**
     * 用户退出，将信息从session中移除
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout.json")
    @ResponseBody
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(); //创建session对象
        session.removeAttribute("user");
        return JSON.toJSONString("true");
    }

    /**
     * 修改用户密码
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping(value = "/updatePwd.json")
    @ResponseBody
    public String updatePwd(@Param("pwd") String pwd,HttpSession session){
        //通过id查询该用户的信息
        Users users=usersService.findById(((Users)session.getAttribute("user")).getUserid());
        //通过set将要修改的值加入
        users.setPassword(pwd);
        //调用service层修改方法
        boolean falg=usersService.update(users);
        if(falg){
            return JSON.toJSONString("true");
        }else{
            return JSON.toJSONString("false");
        }

    }
}
