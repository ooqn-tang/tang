const routeData = [
    {
        path: '/',
        name: 'admin',
        component: () => import('@admin/views/index.vue'),
        redirect: "/article",
        children: [
            {
                path: "article",
                name: "admin_article",
                component: () => import('@admin/views/article.vue'),
                mate: {
                    isM: true,
                    name: '文章管理'
                }
            }, {
                path: "recommend",
                name: "admin_recommend",
                component: () => import('@admin/views/recommend.vue'),
                mate: {
                    isM: true,
                    name: '推荐管理'
                }
            }, {
                path: "author",
                name: "admin_author",
                component: () => import('@admin/views/author.vue'),
                mate: {
                    isM: true,
                    name: '用户管理'
                }
            }, {
                path: "role",
                name: "admin_role",
                component: () => import('@admin/views/role.vue'),
                mate: {
                    isM: true,
                    name: '角色管理'
                }
            }, {
                path: "resource",
                name: "admin_resource",
                component: () => import('@admin/views/resource.vue'),
                mate: {
                    isM: true,
                    name: '资源管理'
                }
            }, {
                path: "template",
                name: "admin_template",
                component: () => import('@admin/views/template.vue'),
                mate: {
                    isM: true,
                    name: '在线代码'
                }
            }
        ]
    }
]

export default routeData;