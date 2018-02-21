<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-setting"></i> 工作流管理</el-breadcrumb-item>
                <el-breadcrumb-item>结点维护</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="handle-box">
            <el-input v-model="SYWKFNODQRYX.sweBusType" placeholder="关联业务类型" class="handle-input mr10"></el-input>
            <el-button type="primary" icon="el-icon-search" @click="query">查询</el-button>
            <el-button type="primary" icon="el-icon-plus" @click="editForm('ADD')" class="add-button">增加</el-button>
            <el-button type="primary" icon="el-icon-plus" @click="submit" class="submit-button">提交</el-button>
        </div>
        <el-dialog title="增加审批人" :visible.sync="addFormVisible" :close-on-click-modal="closeOnclick">
            <el-form :model="SYWKFNODEDTX">
                <el-form-item label="登录名">
                    <el-input v-model="SYWKFNODEDTX.swnLoginName" auto-complete="off" maxlength=60></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="edit">确 定</el-button>
            </div>
        </el-dialog>
        <div class="drag-box-left">
            <div class="drag-title">拖动结点排序</div>
            <div class="drag-list" draggable="true"
            v-for="node in SYWKFNODQRYZ"
            :data-id="node.swnNodeId"
            @dragstart="dragstartEvent"
            @dragend="dragendEvent"
            @dragenter="dragenterEvent"
            @dragleave="dragleaveEvent"
            @dragover="dragoverEvent"
            :key="node.swnNodeId">{{node.swnLoginName}}</div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            SYWKFNODQRYX: {
                sweBusType: ''
            },
            SYWKFNODQRYZ: [{
                swnNodeId:'',
                swnNodeName: '',
                swnLoginName: '',
                seq: ''
            }],
            SYWKFNODEDTX: {
                swnLoginName: ''
            },
            SYWKFNODDELX: {
                swnLoginName: ''
            },
            addFormVisible: false,
            isUpdate: false,
            formType: '',
            index: 0,
            sizeOfList: 0,
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
                SYWKFNODQRYX: [this.SYWKFNODQRYX]
            }
            self.$http
                .post('/wkf/wkfNodesOfEntityQuery.json', input)
                .then((res) => {
                    var pkgOut = res.data
                    // var pkgOut = JSON.parse(res.data)
                    self.SYWKFNODQRYZ = pkgOut.SYWKFNODQRYZ
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
            }
        },
        edit () {
            let self = this

        },
        submit(){

        },
        dragstartEvent (ev) {
            const self = this;
            self.dragElement = ev.target;
            ev.target.style.backgroundColor = '#f8f8f8';
        },
        dragendEvent (ev) {
            ev.target.style.backgroundColor = '#fff';
            ev.preventDefault();
        },
        dragenterEvent (ev) {
            const self = this;
            if (self.dragElement != ev.target) {
                ev.target.parentNode.insertBefore(self.dragElement, ev.target);
            }
        },
        dragleaveEvent (ev) {
            const self = this;
            if (self.dragElement != ev.target) {
                if (self.lock && (ev.target == ev.target.parentNode.lastElementChild || ev.target == ev.target.parentNode.lastChild)) {
                    ev.target.parentNode.appendChild(self.dragElement);
                    self.lock = false;
                } else {
                    self.lock = true;
                }
            }
        },
        dragoverEvent (ev) {
            ev.preventDefault();
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
	right:90px;
}
.submit-button {
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
