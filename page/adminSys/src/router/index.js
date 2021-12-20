import {createRouter, createWebHashHistory} from 'vue-router'
import Login from "@/components/Login";
import Control from "@/components/Control";
import controlChildren from "@/router/controlChildren";


const routes = [
    {
        path: '/',
        name: 'Control',
        component: Control,
        children: controlChildren
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

/*router.beforeEach((to,
                   form, next) => {
    let token = getToken();
    if (!to.path.startsWith('/login')) {
        //token存在且未过期
        if (token !== null && jwtDecode(token).exp >= (new Date().getTime()) / 0x3e8) {
            next()
        } else {
            next({path: '/login'})
        }
    } else {
        //如果它是要去登录的,删除localStorage里的token
        next()
    }
})*/

export default router
