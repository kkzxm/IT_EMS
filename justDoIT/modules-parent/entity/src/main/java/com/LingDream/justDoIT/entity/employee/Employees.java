package com.LingDream.justDoIT.entity.employee;

import com.lingDream.justDoIT.tool.root.ThereEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/20 0020 15:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Employees extends ThereEntity {
    private String phone;
}
