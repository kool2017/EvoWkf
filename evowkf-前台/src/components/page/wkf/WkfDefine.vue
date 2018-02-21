<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-setting"></i> 工作流管理</el-breadcrumb-item>
                <el-breadcrumb-item>工作流定义</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="handle-box">
            <el-input v-model="SYWKFDEFQRYX.swdWkfCode" placeholder="模式代号" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="el-icon-search" @click="query">查询</el-button>
            <el-button type="primary" icon="el-icon-plus" @click="editForm('ADD')" class="add-button">增加</el-button>
        </div>
        <el-dialog title="增加工作流定义" :visible.sync="addFormVisible" :close-on-click-modal="closeOnclick">
            <el-form :model="SYWKFDEFEDTX">
                <el-form-item label="模式代号">
                    <el-input v-model="SYWKFDEFEDTX.swdWkfCode" auto-complete="off" maxlength=4 :disabled="isUpdate"></el-input>
                </el-form-item>
                <el-form-item label="名称">
                    <el-input v-model="SYWKFDEFEDTX.swdWkfName" auto-complete="off" maxlength=60></el-input>
                </el-form-item>
                <el-form-item label="流程模型">
                    <el-select v-model="SYWKFDEFEDTX.swdWkfType" placeholder="请选择流程模型">
                        <el-option label="线型" value="A1"></el-option>
                        <el-option label="树型" value="B1"></el-option>
                        <el-option label="环型" value="C1"></el-option>
                        <el-option label="图型" value="D1"></el-option>
                        <el-option label="复合型" value="E1"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="路由类型">
                    <el-select v-model="SYWKFDEFEDTX.swdRouteType" placeholder="请选择路由类型">
                        <el-option label="单路" value="SI"></el-option>
                        <el-option label="多路" value="MU"></el-option>
                        <el-option label="不限" value="AL"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="edit">确 定</el-button>
            </div>
        </el-dialog>
        <el-table :data="SYWKFDEFQRYZ" border style="width: 100%" ref="multipleTable" stripe >
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="swdWkfCode" label="模式代号" sortable width="150">
            </el-table-column>
            <el-table-column prop="swdWkfName" label="名称">
            </el-table-column>
            <el-table-column prop="swdWkfType" label="流程模型" width="150">
            </el-table-column>
            <el-table-column prop="swdRouteType" label="路由类型" width="150">
            </el-table-column>
            <el-table-column prop="swdWkfStatus" label="工作流状态" width="150">
            </el-table-column>
            <el-table-column label="操作" width="180" fixed="right">
                <template slot-scope="scope">
                    <el-button size="small" @click="editForm('UPDATE',scope.$index)">编辑</el-button>
                    <el-button size="small" type="danger" @click="closeOne(scope.$index)">关闭</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="pagination">
            <el-pagination layout="prev, pager, next" :total="100">
            </el-pagination>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            SYWKFDEFQRYX: {
                swdWkfCode: ''
            },
            SYWKFDEFQRYZ: [{
                swdWkfCode: '',
                swdWkfName: '',
                swdWkfType: '',
                swdRouteType: '',
                swdWkfStatus: ''
            }],
            SYWKFDEFEDTX: {
                swdWkfCode: '',
                swdWkfName: '',
                swdWkfType: '',
                swdRouteType: ''
            },
            SYWKFDEFDELX: {
                swdWkfCode: ''
            },
            addFormVisible: false,
            isUpdate: false,
            formType: '',
            index: 0,
            closeOnclick: false
        }
    },
    created () {
        this.query();
    },
    methods: {
        query () {
            let self = this
            var input = {
                SYWKFDEFQRYX: [this.SYWKFDEFQRYX]
            }
            self.$http
                .post('/wkf/wkfDefineQuery.json', input)
                .then((res) => {
                    var pkgOut = res.data
                    // var pkgOut = JSON.parse(res.data)
                    self.SYWKFDEFQRYZ = pkgOut.SYWKFDEFQRYZ
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('查询出错了')
                })
        },
        editForm (formType, index) {
            let self = this
            self.formType = formType
            self.addFormVisible = true
            if (formType === 'ADD') {
                self.isUpdate = false
                self.SYWKFDEFEDTX = {
                    swdWkfCode: '',
                    swdWkfName: '',
                    swdWkfType: '',
                    swdRouteType: '',
                    swdWkfStatus: ''
                }
            } else if (formType === 'UPDATE') {
                self.isUpdate = true
                self.index = index
                self.SYWKFDEFEDTX = self.SYWKFDEFQRYZ[index]
            }
        },
        edit () {
            let self = this
            var input = {
                SYWKFDEFEDTX: [self.SYWKFDEFEDTX]
            }
            let url = ''

            if (self.formType === 'ADD') {
                url = '/wkf/wkfDefineAdd.json'
            } else if (self.formType === 'UPDATE') {
                url = '/wkf/wkfDefineUpdate.json'
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
            self.SYWKFDEFDELX = self.SYWKFDEFQRYZ[index]
            var input = {
                SYWKFDEFDELX: [self.SYWKFDEFDELX]
            }
            self.$http
                .post('/wkf/wkfDefineClose.json', input)
                .then((res) => {
                    self.query()
                    self.$message({
                        message: '工作流[' + self.SYWKFDEFQRYZ[index].swdWkfName + ']被关闭',
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
	position:fixed;
	right:70px;
}
.handle-select {
  width: 120px;
}
.handle-input {
  width: 300px;
  display: inline-block;
}
</style>
