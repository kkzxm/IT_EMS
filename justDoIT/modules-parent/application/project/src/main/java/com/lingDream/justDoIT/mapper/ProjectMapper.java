package com.lingDream.justDoIT.mapper;

import com.LingDream.justDoIT.entity.project.Project;
import com.lingDream.justDoIT.tool.root.ThereMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/22 0022 18:29
 */
@Mapper
public interface ProjectMapper extends ThereMapper<Project> {
}
