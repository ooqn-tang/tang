import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    children: [{
      path: 'dashboard',
      name: '堂堂程序员',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '堂堂程序员', icon: 'dashboard' }
    }]
  },

  {
    path: '/member',
    component: Layout,
    children: [
      {
        path: 'member',
        name: 'member',
        component: () => import('@/views/member/index'),
        meta: { title: '成员管理', icon: 'el-icon-s-custom' }
      }
    ]
  },

  {
    path: '/role',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'role',
        component: () => import('@/views/role/index'),
        meta: { title: '角色管理', icon: 'el-icon-s-opportunity' }
      }
    ]
  },

  {
    path: '/csgl',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'csgl',
        component: () => import('@/views/role/index'),
        meta: { title: '参数管理', icon: 'el-icon-s-order' }
      }
    ]
  },

  {
    path: '/tjgl',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'tjgl',
        component: () => import('@/views/role/index'),
        meta: { title: '推荐管理', icon: 'el-icon-s-promotion' }
      }
    ]
  },

  {
    path: '/nested',
    component: Layout,
    redirect: '/nested/menu1',
    name: 'Nested',
    meta: {
      title: '系统管理',
      icon: 'nested'
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/nested/menu1/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: 'Menu1' },
        children: [
          {
            path: 'menu1-1',
            component: () => import('@/views/nested/menu1/menu1-1'),
            name: 'Menu1-1',
            meta: { title: 'Menu1-1' }
          },
          {
            path: 'menu1-2',
            component: () => import('@/views/nested/menu1/menu1-2'),
            name: 'Menu1-2',
            meta: { title: 'Menu1-2' },
            children: [
              {
                path: 'menu1-2-1',
                component: () => import('@/views/nested/menu1/menu1-2/menu1-2-1'),
                name: 'Menu1-2-1',
                meta: { title: 'Menu1-2-1' }
              },
              {
                path: 'menu1-2-2',
                component: () => import('@/views/nested/menu1/menu1-2/menu1-2-2'),
                name: 'Menu1-2-2',
                meta: { title: 'Menu1-2-2' }
              }
            ]
          },
          {
            path: 'menu1-3',
            component: () => import('@/views/nested/menu1/menu1-3'),
            name: 'Menu1-3',
            meta: { title: 'Menu1-3' }
          }
        ]
      },
      {
        path: 'menu2',
        component: () => import('@/views/nested/menu2/index'),
        name: 'Menu2',
        meta: { title: 'menu2' }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://panjiachen.github.io/vue-element-admin-site/#/',
        meta: { title: '官网', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router