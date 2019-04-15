package cn.agent.controller;

import cn.agent.pojo.Keyword;
import cn.agent.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/selKeywordByPageAndName")
    public
    ModelAndView selKeywordByPageAndName(String kwname, Integer pageSum) {
        Page<Keyword> keywordPage = keywordService.findPageKeyword( kwname, pageSum==null?0:pageSum );
        ModelAndView modelAndView = new ModelAndView( "" );
        modelAndView.addObject( "keywordPage", keywordPage );
        return modelAndView;
    }

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
    }


}
