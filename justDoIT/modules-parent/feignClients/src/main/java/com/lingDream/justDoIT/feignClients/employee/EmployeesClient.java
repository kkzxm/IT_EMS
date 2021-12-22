package com.lingDream.justDoIT.feignClients.employee;

import com.LingDream.justDoIT.entity.employee.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/22 0022 0:03
 */
@FeignClient("employees")
@Component
public interface EmployeesClient {
    @GetMapping("/employees/{id}")
    Employees findById(@PathVariable("id") Long id);
}
