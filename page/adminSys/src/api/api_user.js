import * as API from './methods'
import {ElMessage} from "element-plus";

let baseURL = {
    employees: "/employees",
    department: "/department",
    project: "/project"
}
let publicMethod = {
    //提示消息
    ElMessage(message) {
        ElMessage({
            showClose: true,
            message: message,
            duration: 1000,
            type: 'success',
        })
    },
    //针对简单的增删查改
    page(key, params, successFun, errFun) {
        return API.GET(baseURL[key] + '/getPage', params, (data) => {
            successFun(data.data);
        }, errFun)
    },
    addOrUpdate: (key, params, successFun, errFun) => {
        return API.POST(baseURL[key] + "/addOrUpdate", params, (data) => {
            successFun(data);
            publicMethod.ElMessage(data.message);
        }, errFun)
    },
    del: (key, params, successFun, errFun) => {
        return API.DELETE(baseURL[key] + "/del", params, (data) => {
            successFun(data);
            publicMethod.ElMessage(data.message)
        }, errFun)
    }
}
export default {
    //密码登录
    login: params => {
        API.POST('admin/login', params)
    },
    /*员工管理*/
    employees: {
        page: (params, successFun, errFun) => {
            publicMethod.page("employees", params, successFun, errFun);
        },
        addOrUpdate: (params, successFun, errFun) => {
            publicMethod.addOrUpdate("employees", params, successFun, errFun);
        },
        del: (key, params, successFun, errFun) => {
            publicMethod.del("employees", params, successFun, errFun);
        },
    },
    /*部门管理*/
    department: {
        page: (params, successFun, errFun) => {
            publicMethod.page("department", params, successFun, errFun);
        },
        addOrUpdate: (params, successFun, errFun) => {
            publicMethod.addOrUpdate("department", params, successFun, errFun);
        },
        del: (key, params, successFun, errFun) => {
            publicMethod.del("department", params, successFun, errFun);
        },
    },
    /*项目管理*/
    project: {
        page: (params, successFun, errFun) => {
            publicMethod.page("project", params, successFun, errFun);
        },
        addOrUpdate: (params, successFun, errFun) => {
            publicMethod.addOrUpdate("project", params, successFun, errFun);
        },
        del: (key, params, successFun, errFun) => {
            publicMethod.del("project", params, successFun, errFun);
        },
    }
}
