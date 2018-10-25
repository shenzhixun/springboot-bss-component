package com.ejet.bss.userinfo.service.impl;

import com.ejet.bss.userinfo.comm.TokenHelper;
import com.ejet.bss.userinfo.vo.SysAccountUpdateVO;
import com.ejet.bss.userinfo.vo.SysAccountVO;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.UuidUtils;
import com.ejet.comm.utils.des.MD5;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.global.CoConstant;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysAccountModel;
import com.ejet.bss.userinfo.mapper.SysAccountDao;
import com.ejet.bss.userinfo.service.ISysAccountService;
@Service("sysAccountService")
public class SysAccountServiceImpl implements ISysAccountService { 
	private final Logger log = LoggerFactory.getLogger(SysAccountServiceImpl.class);
	@Autowired
	private SysAccountDao mDao;
	@Override
	public int insertAutoKey(SysAccountModel model) throws CoBusinessException {
	    if(StringUtils.isBlank(model.getName()) || StringUtils.isBlank(model.getPassword())) {
	        throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
        model.setPassword(MD5.getMD5(model.getPassword()));
        if(model.getUuid()==null) {
            model.setUuid(UuidUtils.getUUID());
        }
        String time = TimeUtils.getCurrentTimeInString();

        model.setEffectStart(model.getEffectStart()==null ? time : model.getEffectStart());
        model.setEffectEnd(model.getEffectEnd()==null ? "209901010001001" : model.getEffectEnd());

        model.setCreateTime(time);
        model.setModifyTime(time);
        model.setModifyUser(TokenHelper.getAccountUuid());
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
        return mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysAccountModel model) throws CoBusinessException { 
 		if(model.getId()==null && model.getUuid()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
        String time = TimeUtils.getCurrentTimeInString();
        model.setModifyTime(time);
 		model.setModifyUser(TokenHelper.getAccountUuid());
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysAccountModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysAccountModel findByPK(SysAccountModel model) throws CoBusinessException {
        if(model.getId()==null && model.getUuid()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
        }
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysAccountModel> queryByCond(SysAccountModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysAccountModel> queryByPage(SysAccountModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<SysAccountModel> list = mDao.queryByPage(model);
		PageBean<SysAccountModel> page = new PageBean<SysAccountModel>(list);
 		return page;
 	}

	public int insertSingle(SysAccountModel model) throws CoBusinessException { 
 		int maxId = insertAutoKey(model);
 		return maxId;
 	}

    public SysAccountVO login(SysAccountModel model) throws CoBusinessException {
        return mDao.login(model);
    }


    /**
     * 更新密码
     * @param model
     * @throws CoBusinessException
     */
    public void updatePassword(SysAccountUpdateVO model)  throws CoBusinessException {
        if(StringUtils.isBlank(model.getPassword()) || StringUtils.isBlank(model.getNewPassword()) ) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
        String uuid = TokenHelper.getAccountUuid();
        if(uuid==null) {
            throw new CoBusinessException(ExceptionCode.SYS_HINT, "登录信息为空!"); //查无登录信息
        }
        model.setUuid(uuid);
        SysAccountModel result = mDao.findAllByPK(model); // 先查询账号
        if(result==null) {
            throw new CoBusinessException(ExceptionCode.SYS_ERROR, "更新密码，无用户信息错误!");
        }
        if(!MD5.getMD5(model.getPassword()).equals(result.getPassword())) {
            throw new CoBusinessException(ExceptionCode.SYS_ERROR, "验证旧密码错误!");
        }
        result.setPassword(MD5.getMD5(model.getNewPassword()));
        update(result);
        //修改密码后，重新删除失效，需要重新登录
        TokenHelper.delToken(TokenHelper.getToken());
    }

    /**
     * 重置密码(可批量，根据账号uuid更新)
     * @throws CoBusinessException
     */
    public void resetPassword(List<String> list)  throws CoBusinessException {
        if(list==null || list.size()==0) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
        mDao.resetPasswordBatch(list);
    }





}