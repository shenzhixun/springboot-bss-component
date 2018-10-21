package com.ejet.bss.userrights.controller.comm;


import java.util.ArrayList;
import java.util.List;

import com.ejet.bss.userinfo.model.SysUserModel;
import com.ejet.bss.userrights.model.SysAccountModuleRModel;
import com.ejet.bss.userrights.model.SysAccountSyslevelRModel;
import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.bss.userrights.service.comm.SysAccountRightsServiceImpl;
import com.ejet.comm.utils.tree.CoZtreeVO;
import com.ejet.comm.utils.tree.TreeVO;
import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejet.comm.Param;
import com.ejet.comm.Result;
import com.ejet.comm.base.CoBaseController;
import com.ejet.comm.exception.CoBusinessException;
/**
 * 用户权限接口
 *
 * 设置用户菜单： /sys_account_rights/set_user_modules
 * 获取用户菜单： /sys_account_rights/get_user_modules
 * 
 * 获取用户菜单（ztree格式）： /sys_account_rights/get_user_modules_ztree

 * 设置用户数据权限： /sys_account_rights/set_user_syslevels
 * 获取用户数据权限： /sys_account_rights/get_user_syslevels
 * 
 * @author ShenYijie
 *
 */
@Controller
@RequestMapping(value = "/sys_account_rights")
public class SysAccountRightsController extends CoBaseController {

    private final Logger log = LoggerFactory.getLogger(SysAccountRightsController.class);
    @Autowired
    private SysAccountRightsServiceImpl mService;
    
    /**
     * 设置用户菜单权限
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/set_account_modules")
    public Result setAccountModuleRigths(@RequestBody(required = true) Param<List<SysAccountModuleRModel>> param, BindingResult bindResult) {
        Result rs = new Result();
        try {
            checkBindResult(bindResult);
            // List<SysAccountModuleRModel> list = toBean(param.getData(), new TypeReference<List<SysUserModuleModel>>(){ });
            mService.saveAccountModules(param.getData());
        } catch (CoBusinessException e) {
            rs = new Result(e);
            log.error("", e);
        }
        return rs;
    }
    
    /**
     * 设置用户数据权限
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/set_account_syslevels")
    public Result setUserSyslevelRigths(@RequestBody(required = true) Param<List<SysAccountSyslevelRModel>> param, BindingResult bindResult) {
        Result rs = new Result();
        try {
            checkBindResult(bindResult);
            // List<SysAccountSyslevelRModel> list = toBean(param.getData(), new TypeReference<List<SysUserSyslevelModel>>() { });
            mService.saveAccountSyslevels(param.getData());
        } catch (CoBusinessException e) {
            rs = new Result(e);
            log.error("", e);
        }
        return rs;
    }
    
    /**
     * 获取用户数据权限
     */
    @ResponseBody
    @RequestMapping(value = "/get_account_syslevels")
    public Result getAccountSyslevels(@RequestBody(required = true) SysAccountSyslevelRModel model) {
        Result rs = new Result();
        log.info("get_account_syslevels......");
        try {
            List<SysSyslevelModel> extList = mService.getAccountSyslevelsRights(model);
            extList = extList==null ? new ArrayList<SysSyslevelModel>() : extList ;
            rs = new Result(extList);
        } catch (CoBusinessException e) {
            rs = new Result(e);
        } catch (Exception e) {
            log.error("", e);
            rs = new Result(e);
        }
        return rs;
    }
    
    
    /**
     * 获取用户功能菜单信息（ztree格式）
     */
    @ResponseBody
    @RequestMapping(value = "/get_user_modules_ztree")
    public Result getUserModulesZtree(@RequestBody SysUserModel model) {
        Result rs = new Result();
        log.info("get_user_modules......");
        try {
        	if (model == null || model.getUserId() == null) {
                throw new CoBusinessException(CoReturnFormat.PARAM_MISSING);// "用户名为空!"
            }
            List<CoZtreeVO> extList = mService.getUserModuleRightsZtree(model);
            extList = extList==null ? new ArrayList<CoZtreeVO>() : extList ;
            rs = new Result(extList);
        } catch (CoBusinessException e) {
            rs = new Result(e);
            return rs;
        } catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
            return rs;
        }
        return rs;
    }
    
    /**
     * 获取用户功能菜单信息(数组)
     */
    @ResponseBody
    @RequestMapping(value = "/get_user_modules")
    public Result getUserModules(@RequestBody SysUserModel model) {
        Result rs = new Result();
        log.info("get_user_modules......");
        try {
        	if (model == null || model.getUserId() == null) {
                throw new CoBusinessException(CoReturnFormat.PARAM_MISSING);// "用户名为空!"
            }
        	List<SysModuleModel> extList = mService.getUserModuleRights(model);
        	extList = extList==null ? new ArrayList<SysModuleModel>() : extList ;
            rs = new Result(extList);
        } catch (CoBusinessException e) {
            rs = new Result(e);
        } catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }
    
    /**
     * 获取用户功能菜单信息（树结构）
     */
    @ResponseBody
    @RequestMapping(value = "/get_user_tree")
    public Result getUserTree(@RequestBody SysUserModel model){
    	 Result rs = new Result();
         log.info("get_user_tree......");
         try {
         	if (model == null || model.getUserId() == null) {
                 throw new CoBusinessException(CoReturnFormat.PARAM_MISSING);// "用户名为空!"
             }
         	List<TreeVO<SysModuleModel>> userTree = mService.getUserTree(model);
         	userTree = userTree==null ? new ArrayList<TreeVO<SysModuleModel>>() : userTree ;
             rs = new Result(userTree);
         } catch (CoBusinessException e) {
             rs = new Result(e);
         } catch (Exception e) {
             log.error("", e);
             rs = new Result(SYS_ERROR, e);
         }
         return rs;
    }
    
}