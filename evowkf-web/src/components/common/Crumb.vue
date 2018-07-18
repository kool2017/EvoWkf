<template>
    <div class="crumb">
        <el-breadcrumb separator="/">
            <el-breadcrumb-item v-for="item in crumbs" :key="item.title" style="font-size:16px">
                <i :class="item.icon"></i> {{item.title}}</el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>
<script>
export default {
    data () {
        return {
        }
    },
    props: ['crumbs']
}
</script>
<style scoped>
.crumb {
  display: block;
  position: absolute;
  top: 70px;
  left: 250px;
  width: 100%;
  height: 35px;
  background-color: rgb(228, 237, 252);
  padding-top: 15px;
  padding-left: 40px;
}
</style>
