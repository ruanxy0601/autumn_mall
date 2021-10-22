package com.autumn.sys.controller;


import com.autumn.sys.entity.SysUser;
import com.autumn.sys.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ruanxy
 * @since 2021-10-22
 */
@Controller
@RequestMapping("/sys/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @ApiOperation(value = "ceshifangfa", response = SysUser.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected Object selectUser(SysUser sysUser) {
        return iSysUserService.list(new QueryWrapper<SysUser>().eq("id", "123"));
    }

    @ApiOperation(value = "insert")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    protected Object insert (@RequestBody SysUser sysUser) {
        return iSysUserService.save(sysUser);
    }

}
