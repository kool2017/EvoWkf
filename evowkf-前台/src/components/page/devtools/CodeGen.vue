<template>
    <div class="wrap">
        <el-form v-model="SYGENCODEX">
            <el-form-item label="包路径">
                <el-input v-model="SYGENCODEX.PACKAGE"></el-input>
            </el-form-item>
            <el-form-item label="是否生成继承类">
                <el-switch v-model="SYGENCODEX.IS_EXTENDS"></el-switch>
            </el-form-item>
            <el-form-item label="表名(多表以分号;分隔)">
                <el-input v-model="SYGENCODEX.TABLES"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="generate">生成</el-button>
            </el-form-item>
        </el-form>
        <a :href="SYGENCODEZ.URL">{{SYGENCODEZ.FILENAME}}</a>
    </div>
</template>
<script>
export default {
    data () {
        return {
            SYGENCODEX: {
                PACKAGE: '',
                IS_EXTENDS: '',
                TABLES: ''
            },
            SYGENCODEZ: {
                URL: '',
                FILENAME: ''
            }
        };
    },
    methods: {
        generate () {
            let self = this
            var input = {
                SYGENCODEX: [self.SYGENCODEX]
            }
            self.$http
                .post('/sys/devtools/genCode.json', input)
                .then((res) => {
                    console.log(res)
                    self.SYGENCODEZ = res.data.SYGENCODEZ[0]
                    console.log(self.SYGENCODEZ)
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('生成出错了')
                })

        }
    }
}
</script>
<style scoped>
.wrap {
  width: 50%;
  position: relative;
  margin: 10px;
}
</style>
