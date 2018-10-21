package com.ejet.bss.userrights.service.comm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.ejet.bss.userinfo.model.SysAccountModel;
import com.ejet.bss.userinfo.service.impl.SysUserServiceImpl;
import com.ejet.bss.userrights.comm.ModuleBase;
import com.ejet.bss.userrights.comm.ConstantUserRights;
import com.ejet.bss.userrights.model.*;
import com.ejet.bss.userrights.service.impl.*;
import com.ejet.bss.userrights.vo.SysAccountSpecialVO;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.collect.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ejet.comm.exception.CoBusinessException;
@Service("sysAccountRightsService")
public class SysAccountRightsServiceImpl  extends ModuleBase {
	private final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysRoleServiceImpl roleService;
	@Autowired
	private SysRoleModuleRServiceImpl roleModuleRService;
    @Autowired
    private SysRoleSyslevelRServiceImpl roleSyslevelRService;


	@Autowired
	private SysAccountRoleRServiceImpl accountRoleRService;
	@Autowired
	private SysAccountModuleRServiceImpl accountModuleRService;
	@Autowired
	private SysAccountSyslevelRServiceImpl accountSyslevelRService;

    @Autowired
    private SysModuleServiceImpl moduleService;
	@Autowired
	private SysSyslevelServiceImpl syslevelService;

	
	/**
	 *  获得用户归属于角色组
	 */
	public List<SysRoleModel> getAccountRoles(SysAccountModel model) throws CoBusinessException {
		List<SysRoleModel> rsList = new ArrayList<SysRoleModel>();
		//查询用户对应角色
        SysAccountRoleRModel accountRoleQuery = new SysAccountRoleRModel();
		accountRoleQuery.setAccountUuid(model.getUuid());
		List<SysAccountRoleRModel> list = accountRoleRService.queryByCond(accountRoleQuery);
		if(list!=null) {
			for(SysAccountRoleRModel item : list) {
				SysRoleModel tmp = new SysRoleModel();
				tmp.setRoleId(item.getRoleId());
				tmp.setRoleTypeId(item.getRoleTypeId());
				rsList.add(tmp);
			}
		}
		return rsList;
	}
	
	// /**
	//  *  获取用户菜单
	//  *
	//  * @param model
	//  * @return
	//  * @throws Exception
	//  */
	// public List<CoZtreeVO> getUserModuleRightsZtree(SysUserModel model) throws CoBusinessException {
	// 	List<SysModuleModel> list = getUserModuleRights(model);
	// 	if(list!=null && list.size()>0) {
	// 		return transModuleZtree(list, true);
	// 	}
	// 	return null;
	// }
	
	// /**
	//  *  获取用户菜单
	//  *
	//  * @param model
	//  * @return
	//  * @throws Exception
	//  */
	// public List<SysModuleModel> getUserModuleRights(SysUserModel model) throws CoBusinessException {
	// 	//首先查询表sys_usermodule中是否存在个人单独设置的模块功能权限，如果有则直接返回，
	// 	SysUserModuleModel query = new SysUserModuleModel();
	// 	query.setUserId(model.getUserId());
	// 	List<SysModuleModel> usermoduleList = userModuleService.listUserModules(query);
	// 	if(!ListUtils.isEmpty(usermoduleList)) {
	// 		return usermoduleList;
	// 	}
	// 	//如果表sys_usermodule中不存在，否则直接取用户对应角色权限。
	// 	List<SysRoleModel> list = getUserRoles(model);  //获取角色组
	// 	if(!ListUtils.isEmpty(list)) {
	// 		List<SysModuleModel> roleModules = roleModuleRService.listRolesModules(list);
	// 		return roleModules;
	// 	} else { //给默认员工角色类型对应角色
	// 		SysRoleModel roleType = new SysRoleModel();
	// 		roleType.setRoleTypeCode(CoConstant.ROLE_TYPE_CODE_EMPLOYEE);
	// 		List<SysRoleModel> roles = roleService.queryByCond(roleType);
	// 		List<SysModuleModel> roleModules = roleModuleRService.listRolesModules(roles);
	// 		return roleModules;
	// 	}
	// 	//return null;
	// }
	// /**
	//  * 获取用户功能菜单信息（树结构）
	//  * @param model
	//  * @return
	//  * @throws CoBusinessException
	//  */
	// public List<TreeVO<SysModuleModel>> getUserTree(SysUserModel model) throws CoBusinessException {
	// 	// 首先查询表sys_usermodule中是否存在个人单独设置的模块功能权限，如果有则直接返回，
	// 	SysUserModuleModel query = new SysUserModuleModel();
	// 	query.setUserId(model.getUserId());
	// 	List<SysModuleModel> usermoduleList = userModuleService.listUserModules(query);
	// 	if (!ListUtils.isEmpty(usermoduleList)) {
	// 		SysModuleModel moduleModel = new SysModuleModel();
	// 		moduleModel.setModuleId(0);
	// 		return toUserModuleRights(usermoduleList, moduleModel);
	// 	}
	// 	// 如果表sys_usermodule中不存在，否则直接取用户对应角色权限。
	// 	List<SysRoleModel> list = getUserRoles(model); // 获取角色组
	// 	if (!ListUtils.isEmpty(list)) {
	// 		List<SysModuleModel> roleModules = roleModuleRService.listRolesModules(list);
	// 		SysModuleModel moduleModel = new SysModuleModel();
	// 		moduleModel.setModuleId(0);
	// 		return toUserModuleRights(roleModules, moduleModel);
	// 	}  else { //给默认员工角色类型对应角色
	// 		SysRoleModel roleType = new SysRoleModel();
	// 		roleType.setRoleTypeCode(CoConstant.ROLE_TYPE_CODE_EMPLOYEE);
	// 		List<SysRoleModel> roles = roleService.queryByCond(roleType);
	// 		List<SysModuleModel> roleModules = roleModuleRService.listRolesModules(roles);
	// 		SysModuleModel moduleModel = new SysModuleModel();
	// 		moduleModel.setModuleId(0);
	// 		return toUserModuleRights(roleModules, moduleModel);
	// 	}
	// }
	//
	// public List<TreeVO<SysModuleModel>> toUserModuleRights(List<SysModuleModel> page , SysModuleModel model) throws CoBusinessException{
    //     TreeVO<SysModuleModel> moduleTree = CoTreeUtil.getTree(page, model, "moduleId", "modulePid");
    //     return moduleTree.getChild();
    // }
	//
	/**
	 * 获取用户数据权限
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List<SysSyslevelModel> getAccountSyslevelsRights(SysAccountSyslevelRModel model) throws CoBusinessException {
        if (model == null || model.getAccountUuid() == null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);// "用户名为空!"
        }
		//首先查询表sys_usersyslevel中是否存在个人单独设置的模块功能权限，如果有则取， 返回
		List<SysSyslevelModel> rightList = new ArrayList<>();
		try {
		    //先取账户对应设置的权限
            SysAccountSyslevelRModel query = new SysAccountSyslevelRModel();
			query.setAccountUuid(model.getAccountUuid());
			query.setSyslevelType(model.getSyslevelType()); 
			rightList = accountSyslevelRService.listAccountSyslevels(query);
			if(!ListUtils.isEmpty(rightList)) {
				return rightList;
			}
			
			//如果表sys_account_syslevel_r中不存在，否则直接取对应角色权限。
			SysAccountModel accountQuery = new SysAccountModel();
            accountQuery.setUuid(model.getAccountUuid());
			rightList = roleSyslevelRService.listRolesSyslevelsAll(getAccountRoles(accountQuery));
			return rightList;
		}catch (CoBusinessException e) {
			throw e;
		} finally {
			//获取，如果人员为主管角色类型，返回本部门ID数据权限。
			List<SysSyslevelModel> specail = getAccountRightsSpecial(model);
			if(specail!=null && specail.size()>0) {
				rightList.addAll(specail);
			}
		}
	}
	
	/**
	 * 
	 * 如果用户为主管角色类型，默认不分配也具有本部门数据权限
     * // @TODO 后期这部分可放到规则引擎中
     *
	 */
	private List<SysSyslevelModel> getAccountRightsSpecial(SysAccountSyslevelRModel model) throws CoBusinessException {
		List<SysSyslevelModel> rightList = new ArrayList<>();
        SysAccountSpecialVO queryVO = new SysAccountSpecialVO();
		queryVO.setAccountUuid(model.getAccountUuid());
		queryVO.setRoleTypeCode(ConstantUserRights.ROLE_TYPE_CODE_DEPT_MANAGER); //主管角色类型
		queryVO.setSyslevelType(model.getSyslevelType());
		rightList = roleSyslevelRService.listRoleSyslevelsSpecial(queryVO);


        //数据权限体系类型（部门\院系\）所有下级节点都需要。
		SysSyslevelModel sysModel = new SysSyslevelModel();
        sysModel.setSyslevelType(ConstantUserRights.SYSLEVEL_TYPE_DEPT);
        List<SysSyslevelModel> allSys = syslevelService.getSyslevelAll(sysModel);
		
		java.util.Set<SysSyslevelModel> deptSets = new HashSet<>();
		if(rightList!=null && rightList.size()>0) {
			for (SysSyslevelModel item : rightList) {
				if(!rightList.contains(item)) {
					deptSets.add(item);
				}
	        	getUserSyslevelRightsAll(deptSets, allSys, item);
	        }
			rightList.addAll(deptSets);
		}
		return rightList;
	}
	
	
	
	/**
	 * 获取用户所有数据权限(包含父级别，递归查找到最上一级)
	 * @param userId
	 * @return
	 * @throws CoBusinessException
	 */
    public java.util.Set<Integer> getAccountSyslevelRightsAll(Long userId) throws CoBusinessException {
        SysAccountSyslevelRModel model = new SysAccountSyslevelRModel();
        model.setUserId(userId);
        model.setSyslevelType(ConstantUserRights.SYSLEVEL_TYPE_DEPT);
        List<SysSyslevelModel> userSyslevelRights = getAccountSyslevelsRights(model);
        
        SysSyslevelModel sysModel = new SysSyslevelModel();
        sysModel.setSyslevelType(ConstantUserRights.SYSLEVEL_TYPE_DEPT);
        List<SysSyslevelModel> allSys = syslevelService.getSyslevel(sysModel);
        
        java.util.Set<Integer> deptIds = new HashSet<>();
        java.util.Set<SysSyslevelModel> deptSets = new HashSet<>();
        
        for (SysSyslevelModel item : userSyslevelRights) {
        	deptIds.add(item.getSyslevelId());
        	getUserSyslevelRightsAll(deptSets, allSys, item);
        }
        return deptIds;
    }
    
    
    
	/**
	 * 递归查找父节点(直到1级节点)
	 * 
	 * @param set	  返回结果
	 * @param allSys  所有节点数据
	 * @param model	 查找节点
	 * @throws CoBusinessException
	 */
	public void getUserSyslevelRightsAll(java.util.Set<SysSyslevelModel> set, List<SysSyslevelModel> allSys, SysSyslevelModel model) throws CoBusinessException {
		if(model.getLevels()<=1 || model.getSyslevelId()==0) { //顶级节点
			set.add(model);
			return;
		} else {
			for(SysSyslevelModel item : allSys) {
				if(set.contains(item)) { //如果当前节点的父节点已经包含，不要递归
					continue;
				}
				if(item.getSyslevelId().intValue()==model.getSyslevelPid().intValue()) {
					set.add(item);
					getUserSyslevelRightsAll(set, allSys, item);
				}
			}
		}
	}
	
	/**
	 * 设置用户菜单
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
			timeout=36000, rollbackFor={Exception.class,CoBusinessException.class})
	public int saveAccountModules(List<SysAccountModuleRModel> lists) throws CoBusinessException {
		int num = 0;
		if(lists==null || lists.size()==0) {
			throw new CoBusinessException(ExceptionCode.RIGHTS_USER_NO_SELECTED);
		}
		String accountUuid = lists.get(0).getAccountUuid();
        SysAccountModuleRModel del = new SysAccountModuleRModel();
		del.setAccountUuid(accountUuid);
        accountModuleRService.delete(del);

		// @ TODO 后续可以改进为批量插入，
		for(SysAccountModuleRModel model : lists) {
			model.setAccountUuid(accountUuid);
            accountModuleRService.insertSingle(model);
		}
		return num;
	}
	
	/**
	 * 设置用户数据权限
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
			timeout=36000, rollbackFor={Exception.class,CoBusinessException.class})
	public int saveAccountSyslevels(List<SysAccountSyslevelRModel> lists) throws CoBusinessException {
		int num = 0;
		if(lists==null || lists.size()==0) {
			throw new CoBusinessException(ExceptionCode.RIGHTS_USER_NO_SELECTED);
		}
        SysAccountSyslevelRModel del = new SysAccountSyslevelRModel();
		del.setAccountUuid(lists.get(0).getAccountUuid());
        accountSyslevelRService.delete(del);
		// @ TODO 后续可以改进为批量插入，
		for(SysAccountSyslevelRModel model : lists) {
			if(model.getSyslevelId()==null) {
				continue;
			}
            accountSyslevelRService.insertSingle(model);
		}
		return num;
	}
}