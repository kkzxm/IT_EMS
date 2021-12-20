export default [
    {
        path: "/sysmenu",
        name: "sysmenu",
        component: () => import("@/views/sysmenu/sysmenu")
    },
    {
        path: "/api/apiInfo",
        name: "apiInfo",
        component: () => import ("@/views/api/apiInfo")
    },
    {
        path: "/api/apiGroup",
        name: "apiGroup",
        component: () => import("@/views/api/ApiGroup")

    }
]


