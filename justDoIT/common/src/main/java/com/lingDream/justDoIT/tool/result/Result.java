package com.lingDream.justDoIT.tool.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一结果集封装
 *
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-06-18 08:26
 */
@Data
@Accessors(chain = true)
public class Result implements Serializable {
    private boolean success;// 是否成功
    private Integer code;// 返回码
    private String message;// 返回信息
    private Object data;// 返回数据

    public Result () {
        setResultCode(ResultCode.SUCCESS);
    }

    public Result(ResultCode code) {
        setResultCode(code);
    }

    public Result(ResultCode code,Object data) {
        setResultCode(code);
        this.data = data;
    }

    public Result(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    private void setResultCode(ResultCode resultCode){
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
    }
}
