import * as API from './methods'
import {ElMessage} from "element-plus";

let baseURL = {
    employees: "/employees",
    department: "/department"
}
let publicMethod = {
    ElMessage(message) {
        ElMessage({
            showClose: true,
            message: message,
            duration: 1000,
            type: 'success',
        })
    }
}
export default {
    //密码登录
    login: params => {
        return API.POST('admin/login', params)
    },
    /*员工管理*/
    employees: {
        page: (params, successFun, errFun) => {
            return API.GET(`${baseURL.employees}/getPage`, params, (data) => {
                successFun(data.data);
            }, errFun)
        },
        addOrUpdate: (params, successFun, errFun) => {
            return API.POST(`${baseURL.employees}/addOrUpdate`, params, (data) => {
                successFun(data);
                publicMethod.ElMessage(data.message);
            }, errFun)
        },
        del: (params, successFun, errFun) => {
            return API.DELETE(`${baseURL.employees}/del`, params, (data) => {
                successFun(data);
                publicMethod.ElMessage(data.message)
            }, errFun)
        }
    },
    /*部门管理*/
    department: {
        page: (params, successFun, errFun) => {
            return API.GET(`${baseURL.department}/getPage`, params, (data) => {
                successFun(data);
            }, errFun)
        }
    }
}

