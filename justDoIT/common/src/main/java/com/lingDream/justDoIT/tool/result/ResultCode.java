package com.lingDream.justDoIT.tool.result;

/**
 * 状态码枚举
 *
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-06-18 08:31
 */
public enum ResultCode {

    SUCCESS(true, 10000, "操作成功！"),
    //---系统错误返回码-----
    FAIL(false, 10001, "操作失败"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！"),

    //---用户操作返回码  2xxxx----
    LOGIN_SUCCESS(true, 20000, "登录成功"),
    UNAUTHENTICATED(false, 20001, "您还未登录"),
    LOGIN_ERROR(false, 20002, "登录失败:账号或密码错误"),
    UN_AUTHORISE(false, 20003, "权限不足");
    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
