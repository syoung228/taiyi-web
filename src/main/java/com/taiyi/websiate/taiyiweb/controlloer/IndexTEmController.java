package com.taiyi.websiate.taiyiweb.controlloer;

import com.taiyi.websiate.taiyiweb.servcice.FooterService;
import com.taiyi.websiate.taiyiweb.servcice.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Despriction:
 * @Author: syoung
 * @Date:Created in
 * @Modity By:
 */
@RequestMapping("/ndex")
@Controller
public class IndexTEmController {
    @Autowired
    IndexService indexService;
    @Autowired
    FooterService footerService;

    @RequestMapping("/indexData")
    public ModelAndView indexDate(HttpServletRequest request, ModelAndView mv){
        mv.addObject("index",indexService.index(request));
        mv.addObject("footer",footerService.getCompany());

        mv.setViewName("index");
        return mv;
    }
}
