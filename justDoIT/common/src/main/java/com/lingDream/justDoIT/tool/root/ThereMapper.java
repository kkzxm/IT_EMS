package com.lingDream.justDoIT.tool.root;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-07-30 15:28
 */
public interface ThereMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入
     */
    Integer insertList(List<T> list);

    /**
     * 除主键以外的唯一列
     */
    T selectByOnly(T entity);

    /**
     * 自定义分页查询(前置)
     */
    default Page<T> getPage(Page<T> page) {
        return page.setRecords(getPage(page.offset(), page.getSize()));
    }

    /**
     * 自定义分页查询(查询数据库)
     */
    List<T> getPage(@Param("start") Long start, @Param("size") Long size);
}