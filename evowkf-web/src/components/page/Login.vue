<template>
    <div class="login-wrap">
        <div class="ms-title">{{appName}}</div>
        <div class="ms-login">
            <el-tabs type="border-card" v-model="paneName" @tab-click="changeTab">
                <el-tab-pane name="login">
                    <span slot="label">
                        <i class="el-icon-date"></i> 登录</span>
                    <el-form :model="SYLOGINFX" :rules="loginRules" ref="loginForm" label-width="0px" class="loginForm">
                        <el-form-item prop="suiLoginName">
                            <el-input v-model="SYLOGINFX.suiLoginName" placeholder="请输入登录名"></el-input>
                        </el-form-item>
                        <el-form-item prop="suiPwd">
                            <el-input type="password" placeholder="请输入密码" v-model="SYLOGINFX.suiPwd" @keyup.enter.native="loginForm('loginForm')"></el-input>
                        </el-form-item>
                        <div class="login-btn">
                            <el-button type="primary" @click="loginForm('loginForm')">登录</el-button>
                        </div>
                    </el-form>
                </el-tab-pane>
                <el-tab-pane name="register">
                    <span slot="label">
                        <i class="el-icon-date"></i> 注册</span>
                    <el-form v-model="SYREGINFX">
                        <el-form-item prop="suiLoginName" ref="regForm">
                            <el-input v-model="SYREGINFX.suiLoginName" placeholder="请输入登录名"></el-input>
                        </el-form-item>
                        <el-form-item prop="suiPwd">
                            <el-input type="password" v-model="SYREGINFX.suiPwd" placeholder="请输入密码"></el-input>
                        </el-form-item>
                        <el-form-item prop="suiPwdC">
                            <el-input type="password" v-model="SYREGINFX.suiPwdC" placeholder="请确认密码" @keyup.enter.native="registerForm"></el-input>
                        </el-form-item>
                        <div class="login-btn">
                            <el-button type="primary" @click="registerForm">注册</el-button>
                        </div>
                    </el-form>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
import sha256 from 'sha256'
import { Base64 } from 'js-base64'
export default {
    data () {
        return {
            appName: '',
            SYLOGINFX: {
                suiLoginName: '',
                suiPwd: '',
                suiPwdA: '',
                suiPwdB: '',
                suiNewSalt: ''
            },
            SYREGINFX: {
                suiLoginName: '',
                suiPwd: '',
                suiPwdC: ''
            },
            loginRules: {
                suiLoginName: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],
                suiPwd: [
                    { required: true, message: '请输入密码', trigger: 'blur' }
                ]
            },
            paneName: 'login'
        }
    },
    created () {
        this.appName = localStorage.getItem('appName')
        this.$notify({
            title: '演示系统操作说明',
            message: '登录用户kool密码kool,ESC关闭消息',
            duration: 0,
            position: 'bottom-left'
        })
        this.$notify({
            title: '演示系统操作说明',
            message: '每天23:59:59还原数据库',
            duration: 0,
            position: 'bottom-left',
            offset: 100
        })
    },
    methods: {
        loginForm (formName) {
            const self = this
            self.$refs[formName].validate((valid) => {
                if (valid) {
                } else {
                    return false
                }
            })
            let input = {
                SYLOGINFX: [self.SYLOGINFX]
            }
            self.$http
                .post('/sys/user/preLogin', input)
                .then(
                    function (response) {
                        var pkgOut = response.data
                        var userInf = pkgOut.SYUSRINFZ[0]
                        var pwdA = input.SYLOGINFX[0].suiPwd + '|' + userInf.suiSalt
                        var pwdB = input.SYLOGINFX[0].suiPwd + '|' + userInf.suiNewSalt
                        for (var N = 0; N < userInf.suiHashTimes; N++) {
                            pwdA = sha256(pwdA)
                            pwdB = sha256(pwdB)
                        }
                        input.SYLOGINFX[0].suiPwd = ''
                        input.SYLOGINFX[0].suiPwdA = pwdA
                        input.SYLOGINFX[0].suiPwdB = pwdB
                        input.SYLOGINFX[0].suiNewSalt = userInf.suiNewSalt
                        self.$http
                            .post('/sys/user/login', input)
                            .then(
                                function (responseEnd) {
                                    let pkgOutEnd = responseEnd.data
                                    let loginInfo = pkgOutEnd.SYLOGINFZ[0]
                                    localStorage.setItem('userCid', loginInfo.userCid)
                                    localStorage.setItem('loginName', loginInfo.userName)
                                    let signKey = loginInfo.signKey
                                    if (signKey != '' && signKey != null) {
                                        localStorage.setItem('signKey', loginInfo.signKey)
                                    }
                                    let face = loginInfo.face;
                                    if (face != '' && face != null) {
                                        localStorage.setItem('face', face)
                                    } else {
                                        localStorage.setItem('face', '../../../static/img/KOOL.jpg')
                                    }
                                    self.$router.push('/home')
                                    self.$message({
                                        message: '欢迎登录',
                                        type: 'success'
                                    })
                                }
                            )
                            .catch(
                                function (err) {
                                    self.$alert(err, '提示', {
                                        confirmButtonText: '确定',
                                        type: 'error'
                                    })
                                }
                            )
                    }
                )
                .catch(function (err) {
                    self.$alert(err, '提示', {
                        confirmButtonText: '确定',
                        type: 'error'
                    })
                })
        },
        registerForm () {
            const self = this
            var input = {
                SYREGINFX: [self.SYREGINFX]
            }
            input.SYREGINFX[0].suiPwd = Base64.encode(input.SYREGINFX[0].suiPwd)
            input.SYREGINFX[0].suiPwdC = Base64.encode(input.SYREGINFX[0].suiPwdC)
            self.$http.post('/sys/user/register', input)
                .then(function (response) {
                    self.SYREGINFX = {
                        suiLoginName: '',
                        suiPwd: '',
                        suiPwdC: ''
                    }
                    self.$message({
                        message: '注册成功，请登录',
                        type: 'success'
                    })
                    self.paneName = 'login'
                })
                .catch(function (err) {
                    console.log(err)
                    self.$alert(err, '提示', {
                        confirmButtonText: '确定',
                        type: 'error'
                    })
                })
        },
        changeTab () {
        }
    }
}
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  height: 100%;
}
.ms-title {
  position: absolute;
  top: 50%;
  width: 100%;
  margin-top: -230px;
  text-align: center;
  font-size: 30px;
  color: #fff;
}
.ms-login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 280px;
  height: 270px;
  margin: -150px 0 0 -190px;
  padding: 40px;
  border-radius: 5px;
  background: #fff;
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 100%;
  height: 36px;
}
</style>
