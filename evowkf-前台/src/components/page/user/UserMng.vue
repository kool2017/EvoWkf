<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-setting"></i> 用户管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="handle-box">
            <el-input v-model="SYUSRINFQRYX.suiLoginName" placeholder="登录名" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="el-icon-search" @click="query">查询</el-button>
            <el-button type="primary" icon="el-icon-plus" @click="editForm('ADD')" class="add-button">增加</el-button>
        </div>
        <el-dialog title="增加用户" :visible.sync="addFormVisible" :close-on-click-modal="closeOnclick">
            <el-form :model="SYUSRINFEDTX">
                <el-form-item label="登录名">
                    <el-input v-model="SYUSRINFEDTX.suiLoginName" auto-complete="off" maxlength=60 :disabled="isUpdate"></el-input>
                </el-form-item>
                <el-form-item label="手机">
                    <el-input v-model="SYUSRINFEDTX.suiPhone" auto-complete="off" maxlength=20></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="SYUSRINFEDTX.suiMail" auto-complete="off" maxlength=100></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="edit">确 定</el-button>
            </div>
        </el-dialog>
        <el-table :data="SYUSRINFQRYZ" border style="width: 100%" ref="multipleTable">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="suiLoginName" label="登录名" sortable>
            </el-table-column>
            <el-table-column prop="suiPhone" label="手机" width="150">
            </el-table-column>
            <el-table-column prop="suiMail" label="邮箱" width="150">
            </el-table-column>
            <el-table-column prop="suiStatus" label="状态" width="150">
            </el-table-column>
            <el-table-column prop="suiErrorTimes" label="密码错误次数" width="150">
            </el-table-column>
            <el-table-column prop="suiRegisterTime" label="注册时间" width="150">
            </el-table-column>
            <el-table-column label="操作" width="180" fixed="right">
                <template slot-scope="scope">
                    <el-button size="small" @click="editForm('UPDATE',scope.$index)">编辑</el-button>
                    <el-button size="small" type="danger" @click="closeOne(scope.$index)">关闭</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="pagination">
            <el-pagination layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-size="page.pageSize" :total="page.total" :page-count="page.pageCount" :current-page="page.currentPage" :page-sizes="[10, 50, 100]">
            </el-pagination>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            SYUSRINFQRYX: {
                suiLoginName: ''
            },
            SYUSRINFQRYZ: [{
                suiId: '',
                suiLoginName: '',
                suiPhone: '',
                suiMail: '',
                suiFace: '',
                suiStatus: '',
                suiErrorTimes: '',
                suiRegisterTime: ''
            }],
            SYUSRINFEDTX: {
                suiLoginName: '',
                suiPhone: '',
                suiMail: '',
                suiFace: ''
            },
            SYUSRINFDELX: {
                suiId: ''
            },
            addFormVisible: false,
            isUpdate: false,
            formType: '',
            index: 0,
            closeOnclick: false,
            page: {
                pageSize: 10,
                total: 0,
                pageCount: 0,
                currentPage: 1
            }
        }
    },
    created () {
        this.query();
    },
    methods: {
        queryPage () {
            let self = this
            var input = {
                SYUSRINFQRYX: [self.SYUSRINFQRYX],
                SYPAGEINFOY: [self.page]
            }
            self.$http
                .post('/usermng/userQueryPage.json', input)
                .then((res) => {
                    // var pkgOut = JSON.parse(res.data)
                    var pkgOut = res.data
                    self.SYUSRINFQRYZ = pkgOut.SYUSRINFQRYZ
                    self.page = pkgOut.SYPAGEINFOY[0]
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('查询出错了')
                })
        },
        handleSizeChange (pageSize) {
            let self = this
            self.page.pageSize=pageSize
            self.page.currentPage=1
            self.queryPage()
        },
        handleCurrentChange (currentPage) {
            let self = this
            self.page.currentPage=currentPage
            self.queryPage()
        },
        query () {
           this.page= {
                pageSize: 10,
                total: 0,
                pageCount: 0,
                currentPage: 1
            }
            this.queryPage();
        },
        editForm (formType, index) {
            let self = this
            self.formType = formType
            self.addFormVisible = true
            if (formType === 'ADD') {
                self.isUpdate = false
                self.SYUSRINFEDTX = {
                    suiLoginName: '',
                    suiPhone: '',
                    suiMail: '',
                    suiFace: ''
                }
            } else if (formType === 'UPDATE') {
                self.isUpdate = true
                self.index = index
                self.SYUSRINFEDTX = self.SYUSRINFQRYZ[index]
            }
        },
        edit () {
            let self = this
            var input = {
                SYUSRINFEDTX: [self.SYUSRINFEDTX]
            }
            let url = ''
            if (self.formType === 'ADD') {
                url = '/usermng/userAdd.json'
            } else if (self.formType === 'UPDATE') {
                url = '/usermng/userUpdate.json'
            }
            self.$http
                .post(url, input)
                .then((res) => {
                    var pkgOut = res.data
                    // var pkgOut = JSON.parse(res.data)
                    self.addFormVisible = false
                    self.query()
                    self.$message({
                        message: '编辑成功',
                        type: 'success'
                    })
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('编辑出错了')
                })

        },
        closeOne (index) {
            let self = this
            self.SYUSRINFDELX = self.SYUSRINFQRYZ[index]
            var input = {
                SYUSRINFDELX: [self.SYUSRINFDELX]
            }
            self.$http
                .post('/usermng/userClose.json', input)
                .then((res) => {
                    self.query()
                    self.$message({
                        message: '用户[' + self.SYUSRINFQRYZ[index].suiLoginName + ']被关闭',
                        type: 'success'
                    })
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('查询出错了')
                })
        }
    }
}
</script>
<style scoped>
.handle-box {
  margin-bottom: 20px;
}
.add-button {
  position: fixed;
  right: 70px;
}
.handle-select {
  width: 120px;
}
.handle-input {
  width: 300px;
  display: inline-block;
}
</style>
