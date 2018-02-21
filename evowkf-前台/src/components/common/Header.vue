<template>
    <div class="header">
        <div class="logo">EvoWKF开发平台</div>
        <div class="user-info">
            <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    <img class="user-logo" :src="face"> {{suiLoginName}}
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="loginout">退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            name: 'kool',
            face: '../../../static/img/KOOL.jpg'
        }
    },
    computed: {
        suiLoginName () {
            let suiLoginName = localStorage.getItem('loginName')
            return suiLoginName ? suiLoginName : this.name
        }
    },
    created () {
        this.face = localStorage.getItem('face')
    },
    methods: {
        handleCommand (command) {
            if (command == 'loginout') {
                let self = this
                self.$http
                    .get('/user/logout.htm')
                    .catch((err) => {
                        console.log(err)
                    })
                localStorage.removeItem('userId')
                localStorage.removeItem('loginName')
                localStorage.removeItem('face')
                localStorage.removeItem('status')
                this.$router.push('/login')
            }
        }
    }
}
</script>
<style scoped>
.header {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  line-height: 70px;
  color: #fff;
}
.header .logo {
  float: left;
  width: 500px;
  text-align: center;
}
.user-info {
  float: right;
  padding-right: 50px;
  font-size: 16px;
  color: #fff;
}
.user-info .el-dropdown-link {
  position: relative;
  display: inline-block;
  padding-left: 50px;
  color: #fff;
  cursor: pointer;
  vertical-align: middle;
}
.user-info .user-logo {
  position: absolute;
  left: 0;
  top: 15px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
