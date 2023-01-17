import { createRouter, createWebHistory } from 'vue-router';
import Layout from '../components/Layout.vue';
import Index from '../components/Index.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/', redirect: '/index', component: Layout, children: [
        { path: 'index', component: Index },
        { path: 'detail', component: () => import('../components/Detail.vue') },
        { path: 'list', component: () => import('../components/List.vue') },
        { path: 'list-search', component: () => import('../components/ListSearch.vue') },
        { path: 'login', component: () => import('../components/Login.vue') },
        { path: 'sign-up', component: () => import('../components/SignUp.vue') },
        { path: 'sign-up-ending', component: () => import('../components/SignUpEnding.vue') },

        // member
        { path: 'sell', component: () => import('../components/member/Sell.vue') },
        { path: 'update-product', component: () => import('../components/member/UpdateProduct.vue') },

        // member/my-page
        { path: 'my-page', component: () => import('../components/member/my-page/index.vue') },
        { path: 'my-info', component: () => import('../components/member/my-page/MyInfo.vue') },

        // member/find-account
        { path: 'find-id', component: () => import('../components/member/find-account/FindId.vue') },
        { path: 'find-pwd', component: () => import('../components/member/find-account/FindPwd.vue') },

        // member/my-page/leave
        { path: 'leave', component: () => import('../components/member/my-page/leave/Index.vue') },
        { path: 'final-check', component: () => import('../components/member/my-page/leave/FinalCheck.vue') },
        { path: 'survey', component: () => import('../components/member/my-page/leave/Survey.vue') },
      ]
    },
    {
      // member/  == 채팅 페이지만 헤더푸터 달라서 따로 빼놧음~~ㅎㅎ
      path: '/chatting', component: () => import('../components/member/Chatting.vue')
    }

    // }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
