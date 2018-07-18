<template>
  <el-container>
    <el-header>注册</el-header>
    <el-main>
      <el-row type="flex" justify="center">
        <el-col :sm="8">
          <el-form v-model="SYREGINFX">
            <el-form-item label="登录名">
              <el-input v-model="SYREGINFX.suiLoginName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input type="password" v-model="SYREGINFX.suiPwd"></el-input>
            </el-form-item>
            <el-form-item label="确认密码">
              <el-input type="password" v-model="SYREGINFX.suiPwdC"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm()">提交</el-button>
              <el-button @click="resetForm()">重置</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>

    </el-main>
  </el-container>
</template>

<script>
import { Base64 } from 'js-base64'
export default {
  data() {
    return {
      SYREGINFX: {
        suiLoginName: '',
        suiPwd: '',
        suiPwdC: ''
      }
    }
  },
  methods: {
    successMsg() {
      this.$message({
        message: '注册成功，请登录',
        type: 'success'
      })
    },
    submitForm() {
      var input = {
        SYREGINFX: [this.SYREGINFX]
      }
      input.SYREGINFX[0].suiPwd = Base64.encode(input.SYREGINFX[0].suiPwd)
      input.SYREGINFX[0].suiPwdC = Base64.encode(input.SYREGINFX[0].suiPwdC)
      this.$http.post('/user/register.json', input)
        .then(function (response) {
          console.log(response)
          this.successMsg()
        }.bind(this))
        .catch(function (err) {
          // console.log(err)
          // this.$message.error('注册失败')
        }.bind(this))
    },
    resetForm() {
      this.SYREGINFX = {
        suiLoginName: '',
        suiPwd: '',
        suiPwdC: ''
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.el-header {
    background-color: #b3c0d1;
    color: #333;
    text-align: center;
    line-height: 60px;
}

.el-main {
    background-color: #e9eef3;
    color: #333;
    text-align: center;
    line-height: 160px;
}

.el-col {
    background: #99a9bf;
    padding-top: 20px;
}

.el-form {
    width: 400px;
    margin: auto;
}
</style>
