package com.lingDream.justDoIT.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.justDoIT.entity.employee.Employees;
import com.lingDream.justDoIT.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/20 0020 20:40
 */
@RestController
@RequestMapping("/employees")
@Controller
public class EmployeesController extends ThereController<Employees> {
    public EmployeesController(IService<Employees> service) {
        super(service, "员工管理");
    }

}
