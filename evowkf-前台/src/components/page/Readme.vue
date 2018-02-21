<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-share"></i> 首页</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <template>
            <div class="block">
                <el-carousel :interval="4000" indicator-position="outside" height="600px" type="card">
                    <el-carousel-item v-for="item in pics" :key="item.name">
                        <div class="card">
                            <a :href="item.url" target="_blank">
                                <h3>{{ item.name }}</h3>
                                <img :src="item.path">
                            </a>
                        </div>
                    </el-carousel-item>
                </el-carousel>
            </div>
        </template>
<el-popover
  ref="popover1"
  placement="top-start"
  title="标题"
  width="200"
  trigger="hover"
  content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
</el-popover>
    </div>
</template>

<script>
export default {
    data: function () {
        return {
            pics: [
                {
                    path: '../../../../static/img/2018120-195258.jpg',
                    name: 'Element，一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端组件库',
                    summary: 'Element，一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端组件库',
                    url: 'http://element-cn.eleme.io/#/zh-CN'
                },
                {
                    path: '../../../../static/img/2015122311.jpg',
                    name: '一分钟告诉你究竟DevOps是什么鬼',
                    summary: '杜绝浪费,内建质量,创建知识(放大学习),延迟决策(尽量延迟决定),快速交付,尊重人员(团队授权),全局优化',
                    url: 'https://www.cnblogs.com/jetzhang/p/6068773.html'
                },
                {
                    path: '../../../../static/img/2018120-200716.jpg',
                    name: 'VUE，一套用于构建用户界面的渐进式框架',
                    summary: 'Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。',
                    url: 'https://cn.vuejs.org/'
                },
                {
                    path: '../../../../static/img/2018120-201725.jpg',
                    name: 'ZooKeeper，一种为分布式应用所设计的高可用、高性能且一致的开源协调服务',
                    summary: 'ZooKeeper是一种为分布式应用所设计的高可用、高性能且一致的开源协调服务，它提供了一项基本服务：分布式锁服务。',
                    url: 'https://www.cnblogs.com/wuxl360/p/5817471.html'
                }
            ]
        }
    }
}
</script>

<style scoped>
.carousel {
  height: 500px;
}
.el-carousel__item {
  height: 500px;
}
.el-carousel__item h3 {
  color: #020202;
  font-size: 18px;
  opacity: 0.75;
  margin: 10px;
  padding-bottom: 3px;
}
.card {
  background-color: #f3f3f3;
  margin: auto;
  border: 1px solid #8aa9d1;
}
.card a {
  text-align: center;
}
.card img {
  display: block;
  margin: auto;
  height: 400px;
}
</style>
