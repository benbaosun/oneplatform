package com.oneplatform.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesuite.mybatis.plugin.pagination.Page;
import com.oneplatform.base.annotation.ApiPermOptions;
import com.oneplatform.base.constants.PermissionType;
import com.oneplatform.user.dao.entity.UserAssetLogEntity;
import com.oneplatform.user.dto.param.UserAssetLogQueryParam;
import com.oneplatform.user.service.UserAssetLogService;

import io.swagger.annotations.ApiOperation;

/**
 * generated by www.jeesuite.com
 */
@Controller
@RequestMapping("/user_asset_log")
@ApiPermOptions(perms = PermissionType.Logined)
public class UserAssetLogController {

    private @Autowired UserAssetLogService userAssetLogService;
	
	@ApiOperation(value = "分页查询账户流水")
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public @ResponseBody Page<UserAssetLogEntity> pageQueryUserAssetLogs(@RequestBody UserAssetLogQueryParam param) {
		Page<UserAssetLogEntity> page = userAssetLogService.pageQuery(param,param);
		return page;
	}

}
