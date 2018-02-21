<template>
    <div class="wrapper">
        <v-head></v-head>
        <v-sidebar></v-sidebar>
        <div class="content">
            <transition name="move" mode="out-in">
                <router-view></router-view>
            </transition>
        </div>
    </div>
</template>

<script>
import vHead from './Header.vue';
import vSidebar from './Sidebar.vue';
export default {
    created () {
        this.$notify({
            title: '审批流签收功能说明',
            message: '演示系统配置的流程：增加用户-审批1-审批2-终审；其中"审批1"结点的工作组包括"bb"、"testb"2个用户；工作组中1人签收后，其他人无法对该结点进行审批',
            duration: 0,
            position: 'bottom-left'
        })
        this.$notify({
            title: '提示',
            message: '请注意，该演示系统会在每天21：00到22：00自动还原数据库数据，请避开这个时间段测试，谢谢！',
            duration: 0,
            offset: 130,
            position: 'bottom-left'
        })
    },
    components: {
        vHead, vSidebar
    }
}
</script>
<style scoped>
.content {
  background-color: rgb(228, 237, 252);
}
</style>
