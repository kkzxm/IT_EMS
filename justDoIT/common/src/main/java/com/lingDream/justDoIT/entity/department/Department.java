package com.lingDream.justDoIT.entity.department;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/21 0021 14:36
 */
@Data
@Accessors(chain = true)
public class Department {
    @TableId
    private String id;
    private String name;
}
