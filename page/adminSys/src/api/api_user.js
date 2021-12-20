import * as API from './methods'

let baseURL = {
    menu: "celerity/sysMenu",
    apiManager: "celerity/api"
}

export default {
    //密码登录
    login: params => {
        return API.POST('admin/login', params)
    },
    // 菜单管理
    menu: {
        menuTree: (params, successFun, errFun) => {
            return API.GET(`${baseURL.menu}/menuTree`, params, successFun, errFun)
        },
        add: (params, successFun, errFun) => {
            return API.POST(`${baseURL.menu}/save`, params, successFun, errFun)
        },
        del: (params, successFun, errFun) => {
            return API.DELETE(`${baseURL.menu}/removeById`, params, successFun, errFun, false)
        },
        update: params => {
            return API.POST('word/updateById', params)
        }
    },
    apiManager: {
        page: (params, successFun, errFun) => {
            return API.GET(`${baseURL.apiManager}/page`, params, successFun, errFun)
        },
    }
}

