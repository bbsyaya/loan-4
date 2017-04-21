package com.hrbb.loan.web.security.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrbb.loan.web.domain.Result;
import com.hrbb.loan.web.domain.Result.Status;
import com.hrbb.loan.web.domain.query.PrivilegeQuery;
import com.hrbb.loan.web.security.dao.BaseService;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.service.PrivilegeService;

@Controller
@RequestMapping("/admin/privilege")
public class PrivilegeManagementController extends BaseControllerImpl<Privilege, PrivilegeQuery, Integer> {

    private Logger log = LoggerFactory.getLogger(PrivilegeManagementController.class);

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    protected BaseService<Privilege, Integer> getBaseService() {
        return privilegeService;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteOne(@PathVariable("id") Integer id) {
        if (id==null || StringUtils.isBlank(id.toString())) {
            log.error("要删除的ID号为null或空字符串！对象：{}", path.getEntityName());
            return new Result(Status.ERROR, "没有传入要删除的ID号！");
        }
        if (privilegeService.findUsageCount(id) > 0){
            return new Result(Status.ERROR, "要删除的权限正在使用中！");
        }
        int count = getBaseService().deleteById(id);
        if (count == 0)
            return new Result(Status.ERROR, "要删除的记录不存在！");
        log.debug("成功删除{}个对象，id:{},对象:{}", count, id, path.getEntityName());
        return new Result(Status.OK, count);
    }
    
    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addOne(Privilege privilege) {
        Privilege tmpPri= privilegeService.findByName(privilege.getPrivilegeName());
        Result result=null;
        if (tmpPri != null){
            result= new Result(Status.ERROR, "权限名称已经被占用！");
            log.warn("权限名称{}已经被占用",tmpPri.getPrivilegeName());
            return result;
        }
        getBaseService().insert(privilege);
        return new Result(Status.OK, privilege);
    }

}
