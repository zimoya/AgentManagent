package cn.agent.controller;

import cn.agent.dao.UsersDao;
import cn.agent.pojo.*;
import cn.agent.service.*;
import cn.agent.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 关键字
 */
@Controller
@RequestMapping(value = "/keyword")
public
class KeywordController {
    @Autowired
    private
    KeywordService keywordService;
    @Autowired
    private
    UsersService usersService;
    @Autowired
    private
    ServicetimeService servicetimeService;
    @Autowired
    private
    TypesService typesService;
    @Autowired
    private
    LogService logService;
    @Autowired
    private ClientService clientService;

    /**
     * 查询关键字和信息
     * @param kwname 关键字的名称
     * @param pageSum 页数
     * @return
     */
    @ResponseBody
    @RequestMapping("/selKeywordByPageAndName")
    public
    Object selKeywordByPageAndName(String kwname, Integer pageSum) {
        Page<Keyword> keywordPage = keywordService.findPageKeyword( kwname, pageSum==null?0:pageSum );
        for(Keyword k: keywordPage.getContent()){
            k.setTypes( null );
            k.setUsers( null );

        }
        return keywordPage;
    }
/*

    @RequestMapping("/delByid")
    public
    ModelAndView delByid(Long id) {
        ModelAndView modelAndView = new ModelAndView( "" );
        modelAndView.addObject( "delresult", keywordService.delete( id ) );
        return modelAndView;
    }
    @RequestMapping("/updateByid")
    public
    ModelAndView updateByid(Keyword keyword) {
        ModelAndView modelAndView = new ModelAndView( "" );
        modelAndView.addObject( "delresult", keywordService.update(keyword) );
        return modelAndView;
    }
    @RequestMapping("/getCount")
    public
    ModelAndView getCount(String kwname) {
        ModelAndView modelAndView = new ModelAndView( "" );
        modelAndView.addObject( "keywordCount", keywordService.getCount(kwname ) );
        return modelAndView;
    }
    @RequestMapping("/getKeywordById")
    public
    ModelAndView getKeywordById(Long id) {
        ModelAndView modelAndView = new ModelAndView( "" );
        modelAndView.addObject( "keywordEntity", keywordService.findById(id ) );
        return modelAndView;
    }*/


    @ResponseBody
    @RequestMapping("/openApp")
    //开通app
    public Object openApp(HttpSession session, String username, String password,Long keywordId){
        Users user=(Users)session.getAttribute( "" );//获取当前登录的用户
        //如果登录名和密码一致则将当前APP开通并扣费记录日志
        if(!user.getUsername().equals( username )||!user.getPassword().equals( password )){
            return JSON.parseObject( "{\"error\":\"0\",\"message\":\"用户名或密码不正确\"}" );//用户名和密码不正确//返回错误
        }
        //获取关键字
        Keyword keyword=keywordService.findById( keywordId );
        //获取服务类型
        Types types=typesService.findById( 7l );
        //更改状态
        keyword.setAppStatus( 2l );
        //设置服务类型
        keyword.setTypes( types );//设置为上传到苹果商城
        types.getKeywords().add( keyword );//建立关系
        //设置年限
        keyword.setApplylimit(3l);
        keyword.setApplytime( new Date(  ) );
        keyword.setLasttime( DateUtil.addYear( new Date(  ),3l) );//获取当前时间3年后的时间
        keywordService.update( keyword );
        //扣费
        user.setBalance((double)( types.getTypevalue()*3));
        usersService.update( user );
        //添加日志
        Log log=new Log();
        log.setUsers( user );
        log.setLoginfo( "用户进行开通app操作成功,服务年限3年,服务类型:上传到苹果商城" );
        log.setLogtime( new Date(  ) );
        return JSON.parseObject( "{\"error:{\"error\":\"1\",\"message\":\"开通成功\"},\"keyword\":"+JSON.toJSONString( keyword )+",\"types\":"+JSON.toJSONString( types )+"}" );//返回成功后的信息
    }

    @ResponseBody
    @RequestMapping("/getOpenAppPageData")
    //获取开通app中的数据
    public Object getOpenAppPageData(HttpSession session,Long keywordId){
        //返回关键词名称和价格,客户名称和服务类型
        Keyword keyword=keywordService.findById( keywordId );
        Client client=clientService.findById(keyword.getClientid());
        Types types=typesService.findById( 7l );
        //当前用户
        Users user = (Users) session.getAttribute( "" );
        return JSON.parseObject( "{\"user\":"+JSON.toJSONString( user )+",keyword:"+JSON.toJSONString( keyword )+",client:"+JSON.toJSONString(  client)+",types:"+JSON.toJSONString( types )+"}" );
    }

    @ResponseBody
    @RequestMapping("/getRenewAppPageData")
    //获取续费的数据
    public Object getRenewAppPageData(HttpSession session,Long keywordId){

        //关键词名称
        Keyword keyword=keywordService.findById( keywordId );
        //客户名称
        Client client=clientService.findById(keyword.getClientid());
        //服务类别
        Types type =new Types();
        type.setParentid(26l);
        List<Types> types=typesService.findAllTypes( type );
        //服务年限
        Servicetime servicetime=servicetimeService.findById(1l);
        //当前用户
        Users user = (Users) session.getAttribute( "" );
        return JSON.parseObject( "{\"user\":"+JSON.toJSONString( user )+",\"keyword\":"+JSON.toJSONString( keyword )+",\"client\":"+JSON.toJSONString( client )+",\"typess\":"+JSON.toJSONString( types )+",\"servicetime\":"+JSON.toJSONString( servicetime )+"}" );

    }

    @ResponseBody
    @RequestMapping("/renewApp")
    //续费
    public Object renewApp(HttpSession session,Long typesId,Long keywordId,Long openYear){
        //更改服务类别
        //更改服务年限
        //扣除费用
        //记录日志
        Users user=(Users)session.getAttribute( "" );//获取当前登录的用户
        //获取关键字
        Keyword keyword=keywordService.findById( keywordId );
        //获取服务类型
        Types types=typesService.findById( typesId );

        //设置年限
        keyword.setApplylimit(openYear);
        //当APP状态为开通时则不修改这个时间否则修改
        keyword.setApplytime(keyword.getAppStatus()==1? new Date(  ):keyword.getApplytime() );
        //当APP状态为开通时修改时间为:当前的到期时间加上openYear的时间 否则当前时间加上 openYear的时间
        keyword.setLasttime( DateUtil.addYear( keyword.getAppStatus()==1?keyword.getLasttime():new Date(  ),openYear ));
        //更改状态
        keyword.setAppStatus( 2l );
        //设置服务类型
        //建立关系
        keyword.setTypes( types );
        types.getKeywords().add( keyword );
        keywordService.update( keyword );
        //扣费
        user.setBalance((double)( types.getTypevalue()*openYear));
        usersService.update( user );
        //添加日志
        Log log=new Log();
        log.setUsers( user );
        log.setLoginfo( "用户进行续费app操作成功,服务年限"+openYear+"年,服务类型:"+types.getTypename()+",消费:"+(types.getTypevalue()*openYear) );
        log.setLogtime( new Date(  ) );
        return JSON.parseObject( "{\"error:{\"error\":\"1\",\"message\":\"开通成功\"},\"keyword\":"+JSON.toJSONString( keyword )+",\"types\":"+JSON.toJSONString( types )+"}" );//返回成功后的信息

    }
}