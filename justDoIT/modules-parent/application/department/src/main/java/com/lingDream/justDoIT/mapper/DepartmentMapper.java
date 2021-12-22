package com.lingDream.justDoIT.mapper;

import com.LingDream.justDoIT.entity.department.Department;
import com.lingDream.justDoIT.tool.root.ThereMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/21 0021 14:39
 */
@Mapper
public interface DepartmentMapper extends ThereMapper<Department> {
}
