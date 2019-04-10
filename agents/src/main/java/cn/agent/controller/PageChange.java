package cn.agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/page")
public class PageChange {
    /**
     * 进入首页index页面
     * @return
     */
    @RequestMapping(value="/index")
    public String index(){
        return "appAddress";
    }
}
