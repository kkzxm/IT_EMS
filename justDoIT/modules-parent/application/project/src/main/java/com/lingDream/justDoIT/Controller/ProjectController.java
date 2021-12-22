package com.lingDream.justDoIT.Controller;

import com.LingDream.justDoIT.entity.project.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lingDream.justDoIT.tool.result.Result;
import com.lingDream.justDoIT.tool.root.ThereController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/22 0022 18:22
 */
@RestController
@Controller
@RequestMapping("/project")
public class ProjectController extends ThereController<Project> {
    public ProjectController(IService<Project> service) {
        super(service, "项目管理");
    }

    /**
     * 添加或删除项目
     */
    @PostMapping("/addOrUpdate")
    public Result addOrUpdate(Project project) {
        return super.addOrUpdate(project);
    }
}
