package com.autumn.sys.controller;


import com.autumn.sys.entity.SysRole;
import com.autumn.sys.service.ISysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/sys/sys-role")
public class SysRoleController {

    @Autowired
    private ISysRoleService iSysRoleService;

    @ApiOperation(value = "获取角色列表", response = SysRole.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<SysRole> selectList(SysRole sysRole) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("id", sysRole.getId());
        return iSysRoleService.list(wrapper);
    }

    @RequestMapping(value = {"/list", ""})
    public String list(Model model) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "webapp/static/jqgrid";
    }

}
