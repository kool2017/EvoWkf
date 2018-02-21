<template>
    <div class="login-wrap">
        <div class="ms-title">EvoWKF开发平台</div>
        <div class="ms-login">
            <el-tabs type="border-card" v-model="paneName" @tab-click="changeTab">
                <el-tab-pane name="login">
                    <span slot="label">
                        <i class="el-icon-date"></i> 登录</span>
                    <el-form :model="SYLOGINFX" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
                        <el-form-item prop="suiLoginName">
                            <el-input v-model="SYLOGINFX.suiLoginName" placeholder="请输入登录名"></el-input>
                        </el-form-item>
                        <el-form-item prop="suiPwd">
                            <el-input type="password" placeholder="请输入密码" v-model="SYLOGINFX.suiPwd" @keyup.enter.native="loginForm('ruleForm')"></el-input>
                        </el-form-item>
                        <div class="login-btn">
                            <el-button type="primary" @click="loginForm('ruleForm')">登录</el-button>
                        </div>
                    </el-form>
                </el-tab-pane>
                <el-tab-pane name="register">
                    <span slot="label">
                        <i class="el-icon-date"></i> 注册</span>
                    <el-form v-model="SYREGINFX">
                        <el-form-item prop="suiLoginName">
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
            rules: {
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
        this.$notify({
            title: '审批流操作说明',
            message: '1.登录用户aa密码aa；2.用户管理，增加一个用户xx；3.登录用户bb密码bb；4.签收；5.审批通过；6.登录cc密码cc；7.审批通过；8.登录dd密码dd；9.审批通过；10.用户管理查询，用户xx已成功增加；11.登录用户xx密码xx',
            duration: 0,
            position: 'bottom-left'
        })
    },
    methods: {
        loginForm (formName) {
            const self = this
            self.$refs[formName].validate((valid) => {
                if (valid) {
                } else {
                    console.log('error submit!!')
                    return false
                }
            })
            var input = {
                SYLOGINFX: [self.SYLOGINFX]
            }
            self.$http
                .post('/user/preLogin.json', input)
                .then(
                function (response) {
                    // var pkgOut = JSON.parse(response.data)
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
                        .post('/user/login.json', input)
                        .then(
                        function (response) {
                            // let pkgOutEnd = JSON.parse(response.data)
                            let pkgOutEnd = response.data
                            let loginInfo = pkgOutEnd.SYCOMMUNZ[0].LOGIN_INFO
                            localStorage.setItem('userId', loginInfo.suiId);
                            localStorage.setItem('loginName', loginInfo.suiLoginName);
                            let face = loginInfo.suiFace;
                            if (face != '' && face != null) {
                                localStorage.setItem('face', face);
                            } else {
                                localStorage.setItem('face', '../../../static/img/KOOL.jpg');
                            }
                            localStorage.setItem('status', loginInfo.suiStatus);
                            self.$router.push('/readme')
                            self.$message({
                                message: '欢迎登录',
                                type: 'success'
                            })
                        }
                        )
                        .catch(
                        function (err) {
                            console.log(err)
                            self.$message.error('登录失败')
                        }
                        )
                }
                )
                .catch(function (err) {
                    console.log(err)
                    self.$message.error('登录失败')
                })
        },
        registerForm () {
            var input = {
                SYREGINFX: [this.SYREGINFX]
            }
            input.SYREGINFX[0].suiPwd = Base64.encode(input.SYREGINFX[0].suiPwd)
            input.SYREGINFX[0].suiPwdC = Base64.encode(input.SYREGINFX[0].suiPwdC)
            this.$http.post('/user/register.json', input)
                .then(function (response) {
                    this.SYREGINFX = {
                        suiLoginName: '',
                        suiPwd: '',
                        suiPwdC: ''
                    }
                    this.$message({
                        message: '注册成功，请登录',
                        type: 'success'
                    })
                    this.paneName = 'login'
                }.bind(this))
                .catch(function (err) {
                    console.log(err)
                    this.$message.error('注册失败')
                }.bind(this))
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
