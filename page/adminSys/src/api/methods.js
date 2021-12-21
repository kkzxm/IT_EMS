import Env from '@/api/env'

let base = Env.baseURL

//通用方法
/*
post
向服务器端提交数据，请求数据在报文body里
发送一个修改数据的请求，需求数据要从新创建
用于创建，更新，删除资源，查询资源都可以，是不幂等的
 */
import axios from 'axios'
import {ElMessage} from "element-plus";

export const DoAJAX = (method, url, params, successFun, errFun, flag) => {
    return axios[method](`${base}${url}`, params).then(res => {
        let data = res.data;
        if (data.success) {
            successFun(data);
        } else {
            if (flag) {
                ElMessage({
                    showClose: true,
                    message: data.message,
                    duration: 2000,
                    type: 'warning',
                })
            }
            errFun ? errFun(res) : "";
        }
    }).catch(e => {
        console.log(e);
        errFun ? errFun(e) : "";
        ElMessage({
            showClose: true,
            message: e.message,
            type: 'error',
        })
    });
}

export const POST = (url, params, successFun, errFun) => {
    params.timer = new Date().getTime();
    let urlPar = new URLSearchParams();
    for (let paramsKey in params) {
        urlPar.append(paramsKey, params[paramsKey])
    }
    return DoAJAX("post", `${url}`, urlPar, successFun, errFun)
}
/*
get
从服务器端获取数据，请求body在地址栏上
用于获取资源，是幂等的，无副作用
 */
export const GET = (url, params, successFun, errFun, flag) => {
    params.timer = new Date().getTime();
    return DoAJAX("get", `${url}`, {params: params}, successFun, errFun, flag)
}

/*
put
向服务器端提交数据，请求数据在报文body里
发送一个修改数据的请求，需求数据更新（全部更新）
用于添加/更新资源
 */
export const PUT = (url, params, successFun, errFun) => {
    return DoAJAX("put", `${url}`, params, successFun, errFun)
}

/*
delete
向服务器端提交数据，请求数据在报文body里
发送一个删除数据的请求
用于删除资源
 */
export const DELETE = (url, params, successFun, errFun, flag) => {
    return DoAJAX("delete", `${url}`, {params: params}, successFun, errFun, flag)
}
/*
patch
向服务器端提交数据，请求数据在报文body里
发送一个修改数据的请求，需求数据更新（部分更新）
用于更新资源，且是局部更新，比如：user对象，你只更改了name属性，那么他的其他属性值是不会变的，如果你用post，那么其他属性值会被设置为null（全局更新）
 */
export const PATCH = (url, params, successFun, errFun) => {
    return DoAJAX("patch", `${url}`, params, successFun, errFun)
}
