package com.lingDream.justDoIT.entity.employee;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/20 0020 15:12
 */
@Data
public class Employees {
    @TableId
    private String id;
    private String name;
    private String phone;
}
