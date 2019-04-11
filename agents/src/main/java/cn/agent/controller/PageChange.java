package cn.agent.controller;

import cn.agent.dao.AppaddressDao;
import cn.agent.pojo.Appaddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 页面跳转
 */
@Controller
@RequestMapping(value = "/page")
public class PageChange {
    @Autowired
    AppaddressDao a;
    @RequestMapping(value="/test")
    public void test(){
        Appaddress app=new Appaddress();
        app.setAppid( 1l );
        List<Appaddress> listAppaddresss=a.getByAppid( app );
        System.out.println("listAppaddresss is null?---"+listAppaddresss);
        System.out.println("listAppaddresss.Length lg 0?----"+listAppaddresss.size());
        System.out.println("listAppaddresss.OneElement is null?---"+listAppaddresss.get( 0 ));
    }
    /**
     * 进入首页index页面
     * @return
     */
    @RequestMapping(value="/index")
    public String index(){
        return "appAddress";
    }
}
