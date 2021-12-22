package com.lingDream.justDoIT.mapper;

import com.LingDream.justDoIT.entity.employee.Employees;
import com.lingDream.justDoIT.tool.root.ThereMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/20 0020 18:36
 */
@Mapper
public interface EmployeesMapper extends ThereMapper<Employees> {
}
