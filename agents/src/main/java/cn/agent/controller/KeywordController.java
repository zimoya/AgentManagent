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
        Page<Keyword> keywordPage = keywordService.findPageKeyword( kwname, pageSum );
        ModelAndView modelAndView = new ModelAndView( "" );
        modelAndView.addObject( "keywordPage", keywordPage );
        return modelAndView;
    }
}
