package com.ejet.bss.userrights.comm;

import java.util.ArrayList;
import java.util.List;

import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.comm.utils.tree.CoTreeUtil;
import com.ejet.comm.utils.tree.CoZtreeVO;
import com.ejet.comm.utils.tree.TreeVO;

public class ModuleBase {
	
	/**
	 * 功能权限树
	 * 
	 * @param src
	 * @return
	 */
	protected List<CoZtreeVO> transModuleZtree(List<SysModuleModel> src, boolean hasURL) {
		List<CoZtreeVO> dest = new ArrayList<CoZtreeVO>();
		for(SysModuleModel item : src) {
			if(item!=null) {
				CoZtreeVO obj = null;
				if(hasURL) {
					obj = new CoZtreeVO(item.getSortOrder(),
					        item.getModuleId(), 
							item.getModulePid(), 
							item.getModuleLevel(), 
							item.getModuleName(),
							item.getModuleType(),
							item.getCss(),
							item.getModuleNameEn(),
							item.getUrl());
				} else {
					obj = new CoZtreeVO(item.getSortOrder(),
					        item.getModuleId(), 
							item.getModulePid(), 
							item.getModuleLevel(), 
							item.getModuleName(),
							item.getModuleType(),
							item.getModuleNameEn(),
							item.getCss());
				}
				dest.add(obj);
			}
		}
		return dest;
	}
	
	/**
	 * 数据权限树
	 * 
	 * @param src
	 * @return
	 */
	protected List<CoZtreeVO> transSyslevel(List<SysSyslevelModel> src) {
		List<CoZtreeVO> dest = new ArrayList<CoZtreeVO>();
		for(SysSyslevelModel item : src) {
			if(item!=null) {
				CoZtreeVO obj = new CoZtreeVO(null,
				                            item.getSyslevelId(), 
											item.getSyslevelPid(), 
											item.getLevels(), 
											item.getSyslevelName(),
											item.getSyslevelType(),
											item.getLevels()+"",
											item.getExt());
				dest.add(obj);
			}
		}
		return dest;
	}
	
	
	
	/**
	 * 模块菜单树
	 * 
	 * @param src
	 * @return
	 */
	protected List<TreeVO<SysModuleModel>> toModuleTreeVO(List<SysModuleModel> src) {
		SysModuleModel rootNode = new SysModuleModel();
		rootNode.setModuleId(0);//模块根节点定义
		//TreeVO<SysModuleModel>  root = new TreeVO<SysModuleModel>(rootNode);
		TreeVO<SysModuleModel> moduleTree = CoTreeUtil.getTree(src, rootNode, "moduleId", "modulePid", new String[]{"url", "ext"});
		return moduleTree.getChild();
	}

	/**
	 * 菜单树（数据权限）
	 * 
	 * @param src
	 * @return
	 */
	protected List<TreeVO<SysSyslevelModel>> toSyslevelTreeVO(List<SysSyslevelModel> src) {
		SysSyslevelModel rootNode = new SysSyslevelModel();
		rootNode.setLevels(1);
		rootNode.setSyslevelId(1);
		rootNode.setSyslevelPid(0);
		TreeVO<SysSyslevelModel> tree = CoTreeUtil.getTree(src, rootNode, "syslevelId", "syslevelPid", new String[]{"url", "ext"});
		return tree.getChild();
	}




}
