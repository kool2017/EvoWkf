<template>
    <div class="header">
        <div class="logo">{{appName}}</div>
        <div class="user-info">
            <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    <img class="user-logo" :src="face"> {{loginName}}
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="getUserInf">个人信息</el-dropdown-item>
                    <el-dropdown-item command="updatePwd">修改密码</el-dropdown-item>
                    <el-dropdown-item command="loginout">安全退出</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-dialog title="用户详情" :visible.sync="viewFormVisible" :close-on-click-modal="true">
                <el-form :model="viewInfo" ref="viewForm" :label-position="labelPosition" label-width="120px">
                    <el-card>
                        <span>用户信息:</span>
                        <hr class="split" />
                        <div class="card-context">
                            <el-row :gutter="10">
                                <el-col :span="10">
                                    <el-form-item label="用户号:">
                                        <el-input v-model="viewInfo.userDtl.userCid" size="small" readonly></el-input>
                                    </el-form-item>
                                    <el-form-item label="登录名:">
                                        <el-input v-model="viewInfo.userDtl.loginName" size="small" readonly></el-input>
                                    </el-form-item>
                                    <el-form-item label="手机:">
                                        <el-input v-model="viewInfo.userDtl.phone" size="small" readonly></el-input>
                                    </el-form-item>
                                    <el-form-item label="邮箱:">
                                        <el-input v-model="viewInfo.userDtl.mail" size="small" readonly></el-input>
                                    </el-form-item>
                                </el-col>
                                <el-col :span="10" :offset="1">
                                    <el-form-item label="用户类型:">
                                        <el-select v-model="viewInfo.userDtl.type" size="small" disabled>
                                            <el-option label="A-正常" value="A"></el-option>
                                            <el-option label="F-冻结" value="F"></el-option>
                                            <el-option label="E-异常" value="E"></el-option>
                                            <el-option label="P-非工作" value="P"></el-option>
                                            <el-option label="C-关闭" value="C"></el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="是否证书卡用户:">
                                        <el-select v-model="viewInfo.userDtl.hasKey" size="small" disabled>
                                            <el-option label="Y-是" value="Y"></el-option>
                                            <el-option label="N-否" value="N"></el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="证书卡号:">
                                        <el-input v-model="viewInfo.userDtl.keyUid" size="small" readonly></el-input>
                                    </el-form-item>
                                    <el-form-item label="员工编号:">
                                        <el-input v-model="viewInfo.userDtl.staffCid" size="small" readonly></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>
                        </div>
                    </el-card>
                </el-form>
                <div slot="footer">
                    <el-button type="primary" @click="viewFormVisible = false">确 定</el-button>
                </div>
            </el-dialog>
            <el-dialog title="修改密码" :visible.sync="editFormVisible" :close-on-click-modal="true">
                <el-form :model="editInfo" ref="viewForm" :label-position="labelPosition" label-width="120px">
                    <el-card>
                        <span>请输入密码:</span>
                        <hr class="split" />
                        <div class="card-context">
                            <el-row :gutter="10">
                                <el-col :span="10">
                                    <el-form-item label="旧密码:">
                                        <el-input v-model="editInfo.oldPwd" size="small"></el-input>
                                    </el-form-item>
                                    <el-form-item label="新密码:">
                                        <el-input v-model="editInfo.newPwd" size="small"></el-input>
                                    </el-form-item>
                                    <el-form-item label="重复新密码:">
                                        <el-input v-model="editInfo.newPwdC" size="small"></el-input>
                                    </el-form-item>
                                </el-col>
                                <el-col :span="10" :offset="1">
                                </el-col>
                            </el-row>
                        </div>
                    </el-card>
                </el-form>
                <div slot="footer">
                    <el-button @click="editFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="updatePwd">确 定</el-button>
                </div>
            </el-dialog>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            appName: '',
            loginName: '',
            face: '',
            viewFormVisible: false,
            labelPosition: 'left',
            viewInfo: {
                userDtl: {},
                loginLog: []
            },
            editInfo: {},
            editRules: {},
            editFormVisible: false
        }
    },
    created () {
        this.appName = localStorage.getItem('appName')
        this.loginName = localStorage.getItem('loginName')
        this.face = localStorage.getItem('face')
    },
    methods: {
        handleCommand (command) {
            if (command == 'getUserInf') {
                this.viewFormVisible = true
                this.queryDtl()
            } else if (command == 'updatePwd') {
                this.editFormVisible = true
            } else if (command == 'loginout') {
                this.loginOut()
            }
        },
        queryDtl () {
            const self = this
            let input = {
                SYUSRCIDX: [
                    {
                        userCid: localStorage.getItem('userCid')
                    }
                ]
            }
            self.$http
                .post('/sys/user/queryUserDetail', input)
                .then(function (res) {
                    let pkgOut = res.data
                    self.viewInfo = {
                        userDtl: pkgOut.SYUSRDTLZ[0],
                        loginLog: pkgOut.SYLOGINLOGZ
                    }
                })
                .catch((err) => {
                    console.log(err)
                    self.$alert(err, '提示', {
                        confirmButtonText: '确定'
                    })
                })

        },
        loginOut () {
            const self = this
            let input = {
                SYLOGOUTX: [
                    {
                        userCid: localStorage.getItem('userCid')
                    }
                ]
            }
            self.$http
                .post('/sys/user/logout', input)
                .then(function (response) {
                    localStorage.removeItem('userCid')
                    localStorage.removeItem('loginName')
                    localStorage.removeItem('face')
                    localStorage.removeItem('signKey')
                    self.$router.push('/login')
                })
                .catch((err) => {
                    console.log(err)
                    self.$alert(err, '提示', {
                        confirmButtonText: '确定',
                        type: 'error'
                    })
                })

        },
        updatePwd () {
            const self = this
            self.editInfo.userCid = localStorage.getItem('userCid')
            let input = {
                SYUPDPWDX: [self.editInfo]
            }
            self.$http
                .post('/sys/user/updatePwd', input)
                .then(function (res) {
                    self.editFormVisible = false
                    self.loginOut()
                    self.$message({
                        message: '修改密码成功，请重新登录',
                        type: 'success'
                    })
                })
                .catch((err) => {
                    console.log(err)
                    self.$alert(err, '提示', {
                        confirmButtonText: '确定',
                        type: 'error'
                    })
                })
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
  border-radius: 10px;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
