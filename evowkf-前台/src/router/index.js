import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [{
            path: '/',
            redirect: '/login'
        },
        {
            path: '/readme',
            component: resolve => require(['../components/common/Home.vue'], resolve),
            children: [{
                    path: '/',
                    component: resolve => require(['../components/page/Readme.vue'], resolve)
                },
                {
                    path: '/basetable',
                    component: resolve => require(['../components/page/BaseTable.vue'], resolve)
                },
                {
                    path: '/vuetable',
                    component: resolve => require(['../components/page/VueTable.vue'], resolve) // vue-datasource组件
                },
                {
                    path: '/baseform',
                    component: resolve => require(['../components/page/BaseForm.vue'], resolve)
                },
                {
                    path: '/vueeditor',
                    component: resolve => require(['../components/page/VueEditor.vue'], resolve) // Vue-Quill-Editor组件
                },
                {
                    path: '/markdown',
                    component: resolve => require(['../components/page/Markdown.vue'], resolve) // Vue-Quill-Editor组件
                },
                {
                    path: '/upload',
                    component: resolve => require(['../components/page/Upload.vue'], resolve) // Vue-Core-Image-Upload组件
                },
                {
                    path: '/basecharts',
                    component: resolve => require(['../components/page/BaseCharts.vue'], resolve) // vue-schart组件
                },
                {
                    path: '/drag',
                    component: resolve => require(['../components/page/DragList.vue'], resolve) // 拖拽列表组件
                },
                {
                    path: '/usermng',
                    component: resolve => require(['../components/page/user/UserMng.vue'], resolve) // 用户管理
                },
                {
                    path: '/wkfdefine',
                    component: resolve => require(['../components/page/wkf/WkfDefine.vue'], resolve) // 工作流定义
                },
                // {
                //     path: '/wkfentity',
                //     component: resolve => require(['../components/page/wkf/WkfEntity.vue'], resolve) // 工作流实例维护
                // },
                {
                    path: '/wkfnode',
                    component: resolve => require(['../components/page/wkf/WkfNode.vue'], resolve) // 结点维护
                },
                {
                    path: '/approve',
                    component: resolve => require(['../components/page/wkf/WkfApprove.vue'], resolve) // 审批
                },
                {
                    path: '/develop-sql',
                    component: resolve => require(['../components/page/devtools/SQL.vue'], resolve) // 生成数据库sql
                },
                {
                    path: '/excel',
                    component: resolve => require(['../components/page/ExcelImportExport.vue'], resolve) // excel导入导出
                },
                {
                    path: '/develop-code',
                    component: resolve => require(['../components/page/devtools/CodeGen.vue'], resolve) // excel导入导出
                }
            ]
        },
        {
            path: '/login',
            component: resolve => require(['../components/page/Login.vue'], resolve),
            children: [{
                path: 'user/register',
                component: resolve => require(['../components/page/Register.vue'], resolve)
            }]
        }
    ]
})
