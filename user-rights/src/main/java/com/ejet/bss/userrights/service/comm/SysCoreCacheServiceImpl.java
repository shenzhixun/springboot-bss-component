package com.ejet.bss.userrights.service.comm;

import com.ejet.bss.userinfo.service.impl.SysUserServiceImpl;
import com.ejet.bss.userrights.mapper.SysModuleDao;
import com.ejet.bss.userrights.mapper.SysSyslevelDao;
import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.bss.userrights.service.impl.SysModuleServiceImpl;
import com.ejet.bss.userrights.service.impl.SysSyslevelServiceImpl;
import com.ejet.comm.exception.CoBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCoreCacheServiceImpl {

    private final Logger log = LoggerFactory.getLogger(SysCoreCacheServiceImpl.class);
    private final String CACHE_NAME_CORE = "sysCoreCache";

    @Autowired
    private SysModuleServiceImpl moduleService;
    @Autowired
    private SysSyslevelServiceImpl syslevelService;

    @Autowired
    private SysUserServiceImpl sysUserService;

    /**
     * 清除当前所有缓存
     * 
     * @throws Exception
     */
    //@CacheEvict(value=CACHE_NAME_CORE, allEntries = true)
    public void cleanCache() throws Exception {
        log.info("[缓存] 清除节点名称：" + CACHE_NAME_CORE);
    }

   // @Cacheable(value=CACHE_NAME_CORE, key="'getModuleAllCache' + #model.modulePid")
    public List<SysModuleModel> getModuleAll(SysModuleModel model) throws CoBusinessException {
        log.info("[缓存] " + CACHE_NAME_CORE + ", 方法getModuleAll......");
        model.setOrderCond(" module_level, sort_order ");
        List<SysModuleModel> result = moduleService.queryByCond(model);
        return result;
    }

    // @ TODO syslevel缓存 ====================
    //@Cacheable(value=CACHE_NAME_CORE, key="'getSyslevelAllCache' + #model.syslevelId + '_' + #model.syslevelType")
    public List<SysSyslevelModel> getSyslevelAll(SysSyslevelModel model) throws CoBusinessException {
        log.info("[缓存] " + CACHE_NAME_CORE + ", 方法getSyslevelAll......");
        model.setOrderCond(" syslevel_type, levels ");
        List<SysSyslevelModel> result = syslevelService.queryByCond(model);
        return result;
    }





}
