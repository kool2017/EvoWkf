<template>
    <div class="wrap">
    <el-upload class="upload-demo" drag action="/sys/devtools/genSql.json" multiple :on-success="showSql" name = "file">
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或
            <em>点击上传</em>
        </div>
    </el-upload>
    <div style="margin: 20px 0;"></div>
    <el-input type="textarea" v-model="sql" autosize></el-input>
    </div>
</template>
<script>
export default {
    data () {
        return {
            fileList: [
            ],
            sql: '',
            SYXLSSQLZ:[]
        };
    },
    methods: {
        showSql (response, file, fileList) {
            this.sql = response.SYXLSSQLZ[0].sql
        }
    }
}
</script>
<style scoped>
.wrap{
    width: 50%;
    position: relative;
    margin: 10px;
}
.upload-demo {
  width:50%;
}
</style>
