package com.lingDream.justDoIT.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.justDoIT.entity.department.Department;
import com.lingDream.justDoIT.tool.result.Result;
import com.lingDream.justDoIT.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.lingDream.justDoIT.utils.StringUtils.isEmptyByTrim;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/21 0021 14:35
 */
@Controller
@RestController
@RequestMapping("/department")
public class DepartmentController extends ThereController<Department> {
    public DepartmentController(IService<Department> service) {
        super(service, "部门管理");
    }

    /**
     * 添加员工
     */
    @PostMapping("/addOrUpdate")
    public Result save(Department department) {
        if (isEmptyByTrim(department.getId())) {
            return super.save(department);
        } else {
            return super.updateById(department);
        }
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/del")
    public Result del(String id) {
        return super.removeById(id);
    }
}
