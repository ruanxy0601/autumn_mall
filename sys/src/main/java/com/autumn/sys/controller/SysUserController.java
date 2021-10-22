package com.autumn.sys.controller;


import com.autumn.sys.entity.SysUser;
import com.autumn.sys.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

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
@ResponseBody
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @ApiOperation(value = "ceshifangfa", response = SysUser.class)
    @GetMapping(value = "/selectList")
    protected List<SysUser> selectUser(SysUser sysUser) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>();
        wrapper.eq("id", sysUser.getId());
        List<SysUser> userList = iSysUserService.list(wrapper);
        return userList;
    }

    @ApiOperation(value = "insert")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    protected boolean insert (@RequestBody SysUser sysUser) {
        return iSysUserService.save(sysUser);
    }

}
