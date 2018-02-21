<template>
    <div class="sidebar">
        <el-menu :default-active="onRoutes" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" unique-opened router>
            <template v-for="menu in menus">
                <template v-if="menu.subMenus">
                    <el-submenu :index="menu.index" :key="menu.index">
                        <template slot="title">
                            <i :class="menu.icon"></i>{{ menu.title }}
                        </template>
                        <template v-for="subMenu in menu.subMenus">
                            <template v-if="subMenu.itemGroups">
                                <el-submenu :key="subMenu.index" :index="subMenu.index">
                                    <template slot="title">
                                        <i :class="subMenu.icon"></i>{{ subMenu.title }}
                                    </template>
                                    <template v-for="itemGroup in subMenu.itemGroups">
                                        <template v-if="itemGroup.items">
                                            <el-menu-item-group :index="itemGroup.index" :key="itemGroup.index" :title="itemGroup.title">
                                                <el-menu-item v-for="item in itemGroup.items" :index="item.index" :key="item.index">
                                                    {{ item.title }}
                                                </el-menu-item>
                                            </el-menu-item-group>
                                        </template>
                                        <template v-else>
                                            <el-menu-item :index="itemGroup.index" :key="itemGroup.index">
                                                {{ itemGroup.title }}
                                            </el-menu-item>
                                        </template>
                                    </template>
                                </el-submenu>
                            </template>
                            <template v-else-if="subMenu.items">
                                <el-submenu :key="subMenu.index" :index="subMenu.index" :title="subMenu.title">
                                    <el-menu-item v-for="item in subMenu.items" :index="item.index" :key="item.index">
                                        {{ item.title }}
                                    </el-menu-item>
                                </el-submenu>
                            </template>
                            <template v-else>
                                <el-menu-item :index="subMenu.index" :key="subMenu.index">
                                    <i :class="subMenu.icon"></i>{{ subMenu.title }}
                                </el-menu-item>
                            </template>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="menu.index" :key="menu.index">
                        <i :class="menu.icon"></i>{{ menu.title }}
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
export default {
    data () {
        return {
            menus: [
                {
                    icon: 'el-icon-share',
                    index: 'readme',
                    title: '首页'
                },
                // {
                //     icon: 'el-icon-star-on',
                //     index: 'demand',
                //     title: '需求管理',
                //     subMenus: [
                //         {
                //             index: 'demand-highlevel',
                //             title: '紧急需求'
                //         },
                //         {
                //             index: 'demand-normal',
                //             title: '正常需求'
                //         }
                //     ]
                // },
                // {
                //     icon: 'el-icon-date',
                //     index: 'project',
                //     title: '项目管理',
                //     subMenus: [
                //         {
                //             index: 'project-build',
                //             title: '立项管理'
                //         },
                //         {
                //             index: 'project-review',
                //             title: '评审管理'
                //         },
                //         {
                //             index: 'project-wbs',
                //             title: 'WBS管理'
                //         },
                //         {
                //             index: 'project-finish',
                //             title: '结项管理'
                //         }
                //     ]
                // },
                // {
                //     icon: 'el-icon-d-arrow-right',
                //     index: 'develop',
                //     title: '开发管理',
                //     subMenus: [
                //         {
                //             index: 'develop-ui',
                //             title: 'UI组件库',
                //             itemGroups: [
                //                 {
                //                     icon: 'el-icon-menu',
                //                     index: '2',
                //                     title: '表格',
                //                     items: [
                //                         {
                //                             index: 'basetable',
                //                             title: '基础表格'
                //                         },
                //                         {
                //                             index: 'vuetable',
                //                             title: 'Vue表格组件'
                //                         }
                //                     ]
                //                 },
                //                 {
                //                     icon: 'el-icon-date',
                //                     index: '3',
                //                     title: '表单',
                //                     items: [
                //                         {
                //                             index: 'baseform',
                //                             title: '基本表单'
                //                         },
                //                         {
                //                             index: 'vueeditor',
                //                             title: '编辑器'
                //                         },
                //                         {
                //                             index: 'markdown',
                //                             title: 'markdown'
                //                         },
                //                         {
                //                             index: 'upload',
                //                             title: '文件上传'
                //                         }
                //                     ]
                //                 },
                //                 {
                //                     icon: 'el-icon-star-on',
                //                     index: 'basecharts',
                //                     title: '图表'
                //                 }
                //             ],
                //             items: [
                //                 {
                //                     icon: 'el-icon-upload2',
                //                     index: 'drag',
                //                     title: '拖拽'
                //                 },
                //                 {
                //                     icon: 'el-icon-upload2',
                //                     index: 'excel',
                //                     title: 'Excel导入导出'
                //                 }
                //             ]
                //         },
                //         {
                //             index: 'develop-sql',
                //             title: '数据库SQL生成工具'
                //         },
                //         {
                //             index: 'develop-code',
                //             title: '源码生成工具'
                //         }
                //         // ,
                //         // {
                //         //     index: 'develop-mock',
                //         //     title: 'MOCK测试工具'
                //         // }
                //     ]
                // },
                // {
                //     icon: 'el-icon-menu',
                //     index: 'test',
                //     title: '测试管理',
                //     subMenus: [
                //         {
                //             index: 'test-doc',
                //             title: '测试案例管理'
                //         },
                //         {
                //             index: 'test-ct',
                //             title: 'CT交叉测试'
                //         },
                //         {
                //             index: 'test-st',
                //             title: 'ST系统测试'
                //         },
                //         {
                //             index: 'test-uat',
                //             title: 'UAT用户测试'
                //         }
                //     ]
                // },
                // {
                //     icon: 'el-icon-info',
                //     index: 'setting',
                //     title: '配置管理',
                //     subMenus: [
                //         {
                //             index: 'setting-devcfg',
                //             title: '开发环境配置管理'
                //         },
                //         {
                //             index: 'setting-stcfg',
                //             title: 'ST环境配置管理'
                //         },
                //         {
                //             index: 'setting-uatcfg',
                //             title: 'UAT环境配置管理'
                //         },
                //         {
                //             index: 'setting-productioncfg',
                //             title: '生产环境配置管理'
                //         },
                //         {
                //             index: 'setting-devcode',
                //             title: '开发库管理'
                //         },
                //         {
                //             index: 'setting-testcode',
                //             title: '受控库管理'
                //         },
                //         {
                //             index: 'setting-prodcode',
                //             title: '产品库管理'
                //         }
                //     ]
                // },
                // {
                //     icon: 'el-icon-upload',
                //     index: 'deploy',
                //     title: '发布管理',
                //     subMenus: [
                //         {
                //             index: 'deploy-st',
                //             title: '发布ST'
                //         },
                //         {
                //             index: 'deploy-uat',
                //             title: '发布UAT'
                //         },
                //         {
                //             index: 'deploy-prod',
                //             title: '发布上线'
                //         }
                //     ]
                // },
                // {
                //     icon: 'el-icon-bell',
                //     index: 'itil',
                //     title: '运维ITIL',
                //     subMenus: [
                //         {
                //             index: 'itil-schedule',
                //             title: '待办事项'
                //         },
                //         {
                //             index: 'itil-commit',
                //             title: '提交运维单'
                //         },
                //         {
                //             index: 'itil-query',
                //             title: '查询运维单'
                //         }
                //     ]
                // },
                {
                    icon: 'el-icon-setting',
                    index: 'usermng',
                    title: '用户管理'
                },
                {
                    icon: 'el-icon-setting',
                    index: 'wkfmng',
                    title: '工作流管理',
                    subMenus: [
                        // {
                        //     index: 'wkfdefine',
                        //     title: '工作流定义'
                        // },
                        // {
                        //     index: 'wkfentity',
                        //     title: '工作流实例维护'
                        // }, {
                        //     index: 'wkfnode',
                        //     title: '结点维护'
                        // },
                        {
                            index: 'approve',
                            title:'审批'
                        }
                    ]
                }
                // ,
                // {
                //     icon: 'el-icon-setting',
                //     index: 'sys1',
                //     title: '系统',
                //     subMenus: [
                //         {
                //             index: 'sys1-modularA',
                //             title: '模块1-A',
                //             itemGroups: [
                //                 {
                //                     index: 'sys1-modularA-group1',
                //                     title: '功能组1-A-1',
                //                     items: [
                //                         {
                //                             index: 'sys1-modularA-group1-functionA',
                //                             title: '功能1-A-1-A'
                //                         },
                //                         {
                //                             index: 'sys1-modularA-group1-functionB',
                //                             title: '功能1-A-1-B'
                //                         }
                //                     ]
                //                 },
                //                 {
                //                     index: 'sys1-modularA-group2',
                //                     title: '功能组1-A-2',
                //                     items: [
                //                         {
                //                             index: 'sys1-modularA-group2-functionA',
                //                             title: '功能1-A-2-A'
                //                         },
                //                         {
                //                             index: 'sys1-modularA-group2-functionB',
                //                             title: '功能1-A-2-B'
                //                         }
                //                     ]
                //                 }
                //             ],
                //             items: [
                //                 {
                //                     index: 'sys1-modularA-group1-functionA',
                //                     title: '功能1-A-1-A'
                //                 },
                //                 {
                //                     index: 'sys1-modularA-group1-functionB',
                //                     title: '功能1-A-1-B'
                //                 }
                //             ]
                //         },
                //         {
                //             index: 'sys1-modularB',
                //             title: '模块1-B',
                //             itemGroups: [
                //                 {
                //                     index: 'sys1-modularB-group1',
                //                     title: '功能组1-B-1',
                //                     items: [
                //                         {
                //                             index: 'sys1-modularB-group1-functionA',
                //                             title: '功能1-B-1-A'
                //                         },
                //                         {
                //                             index: 'sys1-modularB-group1-functionB',
                //                             title: '功能1-B-1-B'
                //                         }
                //                     ]
                //                 },
                //                 {
                //                     index: 'sys1-modularB-group2',
                //                     title: '功能组1-B-2',
                //                     items: [
                //                         {
                //                             index: 'sys1-modularB-group2-functionA',
                //                             title: '功能1-B-2-A'
                //                         },
                //                         {
                //                             index: 'sys1-modularB-group2-functionB',
                //                             title: '功能1-B-2-B'
                //                         }
                //                     ]
                //                 }
                //             ]
                //         }
                //     ]
                // }
            ]
        }
    },
    computed: {
        onRoutes () {
            return this.$route.path.replace('/', '');
        }
    }
}
</script>

<style scoped>
.sidebar {
  display: block;
  position: absolute;
  width: 250px;
  left: 0;
  top: 70px;
  bottom: 0;
  /* background: #2e363f; */
  background:#409EFF;
  overflow-y: scroll;
}
.sidebar > ul {
  height: 100%;
}
</style>
