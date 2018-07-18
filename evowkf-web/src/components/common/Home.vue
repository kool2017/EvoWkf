<template>
    <div class="wrapper">
        <v-head></v-head>
        <v-sidebar @transferCrumb="getCrumb"></v-sidebar>
        <v-crumb :crumbs="crumbs"></v-crumb>
        <div class="content">
            <transition name="move" mode="out-in">
                <router-view></router-view>
            </transition>
        </div>
    </div>
</template>

<script>
import vHead from './Header.vue'
import vSidebar from './Sidebar.vue'
import vCrumb from './Crumb.vue'
export default {
    data () {
        return {
            crumbs: [
            ]
        }
    },
    methods: {
        getCrumb (msg) {
            this.crumbs = msg
        }
    },
    components: {
        vHead,
        vSidebar,
        vCrumb
    }
}
</script>
<style scoped>
.content {
  display: block;
  position: absolute;
  top: 105px;
  left: 250px;
  bottom: 0;
  background-color: rgb(228, 237, 252);
}
</style>
