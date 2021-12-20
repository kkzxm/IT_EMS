package com.lingDream.justDoIT.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingDream.justDoIT.entity.employee.Employees;
import com.lingDream.justDoIT.mapper.EmployeesMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/20 0020 20:41
 */
@Service
public class EmployeesService extends ServiceImpl<EmployeesMapper, Employees> {
}
