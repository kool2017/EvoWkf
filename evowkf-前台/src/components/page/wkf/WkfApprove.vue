<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-setting"></i> 工作流管理</el-breadcrumb-item>
                <el-breadcrumb-item>审批</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="handle-box">
            <el-input v-model="SYSCHEDULEX.businessType" placeholder="业务类型" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="el-icon-search" @click="query">查询</el-button>
        </div>
        <el-dialog title="审批" :visible.sync="approveFormVisible" :close-on-click-modal="closeOnclick">
            <el-form :model="SYAPPROVEX">
                <el-form-item label="审批意见">
                    <el-input type="textarea" v-model="SYAPPROVEX.dsp" auto-complete="off" maxlength=100 :rows="{minRows: 2, maxRows: 4}"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="reject">否 决</el-button>
                <el-button type="primary" @click="agree">通 过</el-button>
            </div>
        </el-dialog>
        <el-table :data="SYSCHEDULEZ" border style="width: 100%" ref="multipleTable">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="srcTimeBegin" label="流程开始时间" sortable width="150">
            </el-table-column>
            <el-table-column prop="srcBusinessType" label="关联业务类型" width="150">
            </el-table-column>
            <el-table-column prop="srcNodeHeadName" label="首结点名称">
            </el-table-column>
            <el-table-column prop="srcStartLoginName" label="发起人登录名" width="150">
            </el-table-column>
            <el-table-column prop="srcDescription" label="流程概要描述" width="150">
            </el-table-column>
            <el-table-column prop="srcRecordStatus" label="执行状态" width="150">
            </el-table-column>
            <el-table-column prop="swsLastNodeName" label="上一结点名称" width="150">
            </el-table-column>
            <el-table-column prop="swsLastLoginName" label="上一执行人用户登录名" width="150">
            </el-table-column>
            <el-table-column prop="swsScheduleNodeName" label="待办结点名称" width="150">
            </el-table-column>
            <el-table-column prop="swsWgName" label="工作组名称" width="150">
            </el-table-column>
            <el-table-column prop="swsScheduleLoginName" label="签收人登录名" width="150">
            </el-table-column>
            <el-table-column prop="swsScheduleStatus" label="状态" width="150">
            </el-table-column>
            <el-table-column prop="swsCreateTime" label="创建时间" width="150">
            </el-table-column>
            <el-table-column label="操作" width="250" fixed="right">
                <template slot-scope="scope">
                    <el-button size="mini" type="primary" @click="checkConfirm(scope.$index)">签收</el-button>
                    <el-button size="mini" type="primary" @click="approveForm(scope.$index)">审批</el-button>
                    <!-- <el-button size="mini" type="primary" @click="showDetail(scope.$index)">详情</el-button> -->
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="详情" :visible.sync="detailFormVisible" :close-on-click-modal="closeOnclick">
            <el-form :model="SYDETAILQRYZ">
                <el-form-item label="新建用户登录名">
                    <el-input type="textarea" auto-complete="off" maxlength=100 :rows="{minRows: 2, maxRows: 4}"></el-input>
                </el-form-item>
            </el-form>
        </el-dialog>
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
            SYSCHEDULEX: {
                recordId: '',
                businessType: ''
            },
            SYSCHEDULEZ: [{
                srcRecordId: '',
                srcTimeBegin: '',
                srcTimeEnd: '',
                srcWkfCode: '',
                srcEntityId: '',
                srcBusinessId: '',
                srcBusinessType: '',
                srcNodeHead: '',
                srcNodeHeadName: '',
                srcStartUserId: '',
                srcStartLoginName: '',
                srcEndUserId: '',
                srcEndLoginName: '',
                srcDescription: '',
                srcRecordStatus: '',
                swsScheduleId: '',
                swsRecordId: '',
                swsLastNodeId: '',
                swsLastNodeName: '',
                swsLastUserId: '',
                swsLastLoginName: '',
                swsScheduleNodeId: '',
                swsScheduleNodeName: '',
                swsWgId: '',
                swsWgName: '',
                swsScheduleUserId: '',
                swsScheduleLoginName: '',
                swsBranchFlag: '',
                swsBranchHeadId: '',
                swsBranchHeadName: '',
                swsScheduleStatus: '',
                swsCreateTime: ''
            }],
            SYAPPROVEX: {
                recordId: '',
                scheduleId: '',
                approveFlag: '',
                dsp: ''
            },
            SYCHECKX: {
                recordId: '',
                scheduleId: ''
            },
            approveFormVisible: false,
            detailFormVisible: false,
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
                SYSCHEDULEX: [self.SYSCHEDULEX],
                SYPAGEINFOY: [self.page]
            }
            self.$http
                .post('/wkf/wkfQuerySchedules.json', input)
                .then((res) => {
                    // var pkgOut = JSON.parse(res.data)
                    var pkgOut = res.data
                    self.SYSCHEDULEZ = pkgOut.SYSCHEDULEZ
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
        approveForm (index) {
            let self = this
            self.approveFormVisible = true
            self.SYAPPROVEX.recordId = self.SYSCHEDULEZ[index].swsRecordId
            self.SYAPPROVEX.scheduleId = self.SYSCHEDULEZ[index].swsScheduleId
        },
        agree () {
            let self = this
            self.SYAPPROVEX.approveFlag = 'Y'
            var input = {
                SYAPPROVEX: [self.SYAPPROVEX]
            }
            self.$http
                .post('/wkf/wkfApprove.json', input)
                .then((res) => {
                    var pkgOut = res.data
                    // var pkgOut = JSON.parse(res.data)
                    self.approveFormVisible = false
                    self.query()
                    self.$message({
                        message: '已审批',
                        type: 'success'
                    })
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('审批出错了')
                })

        },
        reject () {
            let self = this
            self.SYAPPROVEX.approveFlag = 'N'
            var input = {
                SYAPPROVEX: [self.SYAPPROVEX]
            }
            self.$http
                .post('/wkf/wkfApprove.json', input)
                .then((res) => {
                    var pkgOut = res.data
                    // var pkgOut = JSON.parse(res.data)
                    self.approveFormVisible = false
                    self.query()
                    self.$message({
                        message: '已审批',
                        type: 'success'
                    })
                })
                .catch((err) => {
                    console.log(err)
                    self.$message.error('审批出错了')
                })

        },
        checkConfirm (index) {
            let self = this
            self.SYCHECKX.recordId = self.SYSCHEDULEZ[index].swsRecordId
            self.SYCHECKX.scheduleId = self.SYSCHEDULEZ[index].swsScheduleId
            self.$confirm('确认签收吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'info'
            }).then(() => {
                var input = {
                    SYCHECKX: [self.SYCHECKX]
                }
                self.$http
                    .post('/wkf/wkfCheck.json', input)
                    .then((res) => {
                        var pkgOut = res.data
                        // var pkgOut = JSON.parse(res.data)
                        self.query()
                        self.$message({
                            message: '签收成功',
                            type: 'success'
                        })
                    })
                    .catch((err) => {
                        console.log(err)
                        self.$message.error('签收出错了')
                    })
            }).catch(() => {
                self.$message({
                    type: 'info',
                    message: '已取消签收'
                })
            })

        },
        showDetail (index) {
            let self = this
            self.SYDETAILQRYX = self.SYWKFRECQRYZ[index]
            var input = {
                SYDETAILQRYX: [self.SYDETAILQRYX]
            }
            self.$http
                .post('/wkf/wkfApproveDetail.json', input)
                .then((res) => {
                    var pkgOut = res.data
                    self.SYDETAILQRYZ = pkgOut.SYDETAILQRYZ[0]
                    console.log(self.SYDETAILQRYZ)
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
