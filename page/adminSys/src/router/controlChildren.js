export default [
    {
        path: "/employees",
        name: "employees",
        component: () => import("@/views/employees/employees")
    },
    {
        path: "/department",
        name: "department",
        component: () => import("@/views/department/department")
    }

]