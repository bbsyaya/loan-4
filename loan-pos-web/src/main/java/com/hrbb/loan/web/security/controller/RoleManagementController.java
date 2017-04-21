package com.hrbb.loan.web.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
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
import org.springframework.web.servlet.ModelAndView;

import com.hrbb.loan.web.domain.Result;
import com.hrbb.loan.web.domain.Result.Status;
import com.hrbb.loan.web.domain.query.RoleQuery;
import com.hrbb.loan.web.security.dao.BaseService;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.PrivilegeService;
import com.hrbb.loan.web.security.service.RoleService;

@Controller
@RequestMapping("/admin/role")
public class RoleManagementController extends BaseControllerImpl<Role, RoleQuery, Integer> {

    private Logger log = LoggerFactory.getLogger(RoleManagementController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    protected BaseService<Role, Integer> getBaseService() {
        return roleService;
    }

    @RequestMapping(value = "/lock/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Result lock(@PathVariable("id") Integer id) {
        int count = roleService.lockById(id);
        return new Result(Status.OK, count);
    }

    @ResponseBody
    @RequestMapping(value = "/unlock/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result unlock(@PathVariable("id") Integer id) {
        int count = roleService.unlockById(id);
        return new Result(Status.OK, count);
    }

    @ResponseBody
    @RequestMapping(value = "/lock", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result lockList(Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            log.error("未设置批量lock对象的ID号！对象：{}", path.getEntityName());
            return new Result(Status.ERROR, "没有传入要锁定的ID号数组！");
        }
        try {
            roleService.lockByIdInBatch(Arrays.asList(ids));
        } catch (Exception e) {
            log.error("批量lock对象失败！对象:" + path.getEntityName(), e);
            return new Result(Status.ERROR, "批量锁定失败！");
        }
        return new Result(Status.OK, ids.length);
    }

    @ResponseBody
    @RequestMapping(value = "/unlock", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result unlockList(Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            log.error("未设置批量unlock对象的ID号！对象：{}", path.getEntityName());
            return new Result(Status.ERROR, "没有传入要解锁的ID号数组！");
        }
        try {
            roleService.unlockByIdInBatch(Arrays.asList(ids));
        } catch (Exception e) {
            log.error("批量unlock对象失败！对象:" + path.getEntityName(), e);
            return new Result(Status.ERROR, "批量解锁失败！");
        }
        return new Result(Status.OK, ids.length);
    }
    
    @Override
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addView() {
        return addRoleInfos(new ModelAndView(path.getAddViewPath(), path.getEntityName(), new User()),-1);
    }

    @Override   
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewOne(@PathVariable("id") Integer id) {
        Object obj = getBaseService().queryById(id);
        return addRoleInfos(new ModelAndView(path.getOneViewPath(), path.getEntityName(), obj),id);
    }
    
    @Override
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editView(@PathVariable("id") Integer id) {
        Object obj = getBaseService().queryById(id);
        return addRoleInfos(new ModelAndView(path.getEditViewPath(), path.getEntityName(), obj),id);
    }    
    
    private ModelAndView addRoleInfos(ModelAndView mav, Integer id) {
        List<Privilege> allPrivileges = privilegeService.queryAll();
        mav.addObject("allPrivileges", allPrivileges);
        if (id.intValue()>=0) {
            List<Privilege> privilegesByRole = privilegeService.findPrivielegeByRoleId(id);
            mav.addObject("privilegesByRole", privilegesByRole);   
        }
        return mav;
    }
    
    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addOne(Role role) {
        Role tmpRole = roleService.findByName(role.getRoleName());
        Result result=null;
        if (tmpRole != null){
            result= new Result(Status.ERROR, "组名称已经被占用！");
            log.warn("组名称{}已经被占用",tmpRole.getRoleName());
            return result;
        }
        getBaseService().insert(role);
        String[] privileges = role.getAssignedPrivilegeList().split(",");
        role = roleService.findByName(role.getRoleName());
        if(privileges.length > 0) {
            roleService.deleteRolePrivileges(role.getRoleId());
            roleService.insertRolePrivileges(role.getRoleId(), convertToList(privileges));        
        }
        return new Result(Status.OK, role);
    }
    
    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result editOne(Role role) {
        Role tmpRole = roleService.findByName(role.getRoleName());
        Result result=null;
        if (tmpRole != null && (!tmpRole.equals(role))){
            result= new Result(Status.ERROR, "组名称已经被占用！");
            log.warn("组名称{}已经被占用",tmpRole.getRoleName());
            return result;
        }        getBaseService().updateById(role);
        String[] roles = role.getAssignedPrivilegeList().split(",");
        if(roles.length > 0 && (!StringUtils.isEmpty(roles[0]))) {
            roleService.deleteRolePrivileges(role.getRoleId());
            roleService.insertRolePrivileges(role.getRoleId(), convertToList(roles));        
        }
        return new Result(Status.OK, role);
    }
    
    @Override
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteList(Integer[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            log.error("未设置批量删除对象的ID号！对象：{}", path.getEntityName());
            return new Result(Status.ERROR, "没有传入要删除的ID号数组！");
        }
        try {
            roleService.deleteRolePrivilegesInBatch(Arrays.asList(ids));
            roleService.deleteByIdInBatch(Arrays.asList(ids));
        } catch (Exception e) {
            log.error("批量删除对象失败！对象:" + path.getEntityName(), e);
            return new Result(Status.ERROR, "批量删除失败！");
        }
        return new Result(Status.OK, ids.length);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteOne(@PathVariable("id") Integer id) {
        if (id==null || StringUtils.isBlank(id.toString())) {
            log.error("要删除的ID号为null或空字符串！对象：{}", path.getEntityName());
            return new Result(Status.ERROR, "没有传入要删除的ID号！");
        }
        roleService.deleteRolePrivileges(id);
        int count = roleService.deleteById(id);
        if (count == 0)
            return new Result(Status.ERROR, "要删除的记录不存在！");
        log.debug("成功删除{}个对象，id:{},对象:{}", count, id, path.getEntityName());
        return new Result(Status.OK, count);
    }

    
    private List<Integer> convertToList(String[] array){
        List<Integer> list = new ArrayList<Integer>();
        for (String one : array) {            
            list.add(Integer.valueOf(one));
        }
        return list;
    }
}
