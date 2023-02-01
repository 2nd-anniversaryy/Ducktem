import { createRouter, createWebHistory } from 'vue-router';
import Layout from '/src/components/Layout.vue';
import Index from '/src/components/Index.vue';
import HelpCenter from '/src/components/help-center/HelpCenter.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/index',
      component: Layout,
      children: [
        { path: 'index', component: Index },
        { path: 'detail', name: 'detail', component: () => import('/src/components/Detail.vue') },
        { path: 'list', component: () => import('/src/components/List.vue') },
        { path: 'list-search', component: () => import('/src/components/ListSearch.vue') },
        { path: 'login', component: () => import('/src/components/Login.vue') },
        { path: 'sign-up', component: () => import('/src/components/SignUp.vue') },
        { path: 'sign-up-ending', component: () => import('/src/components/SignUpEnding.vue') },
        {
          path: 'help-center',
          component: HelpCenter,
        },

        // member
        { path: 'sell', component: () => import('/src/components/member/Sell.vue') },
        {
          path: `update-product/:productId`,
          component: () => import('/src/components/member/UpdateProduct.vue'),
        },

        // member/my-page
        { path: 'my-page', component: () => import('/src/components/member/my-page/index.vue') },
        { path: 'my-info', component: () => import('/src/components/member/my-page/MyInfo.vue') },

        // member/find-account
        {
          path: 'find-id',
          component: () => import('/src/components/member/find-account/FindId.vue'),
        },
        {
          path: 'find-pwd',
          component: () => import('/src/components/member/find-account/FindPwd.vue'),
        },

        // member/my-page/leave
        { path: 'leave', component: () => import('/src/components/member/my-page/leave/Index.vue') },
        {
          path: 'final-check',
          component: () => import('/src/components/member/my-page/leave/FinalCheck.vue'),
        },
        {
          path: 'survey',
          component: () => import('/src/components/member/my-page/leave/Survey.vue'),
        },
      ],
    },
    {
      // member/  == 채팅 페이지만 헤더푸터 달라서 따로 빼놧음~~ㅎㅎ
      path: '/chatting',
      component: () => import('/src/components/member/Chatting.vue'),
    },

    // }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ],
  scrollBehavior (to, from, savedPosition) {
    return { x: 0, y: 0 }
  }
});

export default router;
