package com.lingDream.justDoIT.tool.root;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/22 0022 18:26
 */
@Data
public abstract class ThereEntity {
    @TableId
    private String id;
    private String name;
}
