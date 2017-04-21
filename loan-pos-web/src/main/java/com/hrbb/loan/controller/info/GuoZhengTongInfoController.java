package com.hrbb.loan.controller.info;

import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hrbb.loan.pos.biz.backstage.inter.IId5Service;
import com.hrbb.loan.pos.dao.entity.TFixLineInfo;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年10月8日下午4:30:05 
 */
@Controller
@RequestMapping("info/guozhengtong")
public class GuoZhengTongInfoController {

    @Autowired
    private IId5Service id5Service;

    /**
     * @param telNum 座机号码
     * @return 固话（座机）信息
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    @RequestMapping(value = "fixedLine", method = RequestMethod.GET)
    public ModelAndView getFixedLineInfo(@RequestParam String loanId) {
        TFixLineInfo fixedLineInfo = id5Service.queryFixLineInfoDBfirst(loanId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("fixedLine", fixedLineInfo);
        mav.setViewName("review/fixLineInfo");
        return mav;
    }
    
    @RequestMapping(value = "fixedLine/update",method = RequestMethod.GET)
    public ModelAndView updateFixedLineInfo(@RequestParam String loanId){
        ModelAndView mav = new ModelAndView();
        TFixLineInfo fixLineInfo = id5Service.queryFixLineInfoForUpdate(loanId);
        mav.addObject("fixedLine", fixLineInfo);
        mav.setViewName("review/fixLineInfo");
        return mav;
    }
}
