<template>
    <div class="calendar" id="calendar">
        <div class="c-header">
            <el-button type="primary" icon="el-icon-arrow-left" @click="goLastMonth"></el-button>
            <el-date-picker v-model="month" type="month" placeholder="选择月" @change="change">
            </el-date-picker>
            <el-button type="primary" icon="el-icon-arrow-right" @click="goNextMonth"></el-button>
        </div>
        <div class="c-body">
            <el-table :data="calendarData" border :header-cell-class-name="headerCellClassName" :cell-class-name="tableCellClassName">
                <el-table-column prop="sun.day" label="日" width="150">
                </el-table-column>
                <el-table-column prop="mon.day" label="一" width="150">
                </el-table-column>
                <el-table-column prop="tue.day" label="二" width="150">
                </el-table-column>
                <el-table-column prop="wed.day" label="三" width="150">
                </el-table-column>
                <el-table-column prop="thu.day" label="四" width="150">
                </el-table-column>
                <el-table-column prop="fri.day" label="五" width="150">
                </el-table-column>
                <el-table-column prop="sat.day" label="六" width="150">
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
import moment from 'moment'
export default {
    data () {
        return {
            month: '',
            calendarData: [
                {
                    sun: { day: '', date: '' },
                    mon: { day: '', date: '' },
                    tue: { day: '', date: '' },
                    wed: { day: '', date: '' },
                    thu: { day: '', date: '' },
                    fri: { day: '', date: '' },
                    sat: { day: '', date: '' }
                }
            ]
        }
    },
    created () {
        this.month = moment().format('YYYY-MM')
        this.reflash()
    },
    methods: {
        headerCellClassName ({ row, rowIndex }) {
            console.log(JSON.stringify(row))
            return 'header-cell'
        },
        tableCellClassName ({ row, column, rowIndex, columnIndex }) {
            let date = moment(row.sun.date).format('YYYY-MM')
            if (columnIndex === 0 && moment(row.sun.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            } else if (columnIndex === 1 && moment(row.mon.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            } else if (columnIndex === 2 && moment(row.tue.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            } else if (columnIndex === 3 && moment(row.wed.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            } else if (columnIndex === 4 && moment(row.thu.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            } else if (columnIndex === 5 && moment(row.fri.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            } else if (columnIndex === 6 && moment(row.sat.date).format('YYYY-MM') === this.month) {
                return 'current-month-cell';
            }
            return ''
        },
        goLastMonth () {
            let self = this
            let month = self.month
            self.month = moment(month).subtract(1, 'months').format('YYYY-MM')
            self.refrash()
            // var input = {}
            // self.$http
            //     .post('/calendar', input)
            //     .then((res) => {
            //         console.log(res)
            //         var pkgOut = res.data
            //         self.calendarData = pkgOut.SYCALENDAR
            //         console.log(pkgOut)
            //     })
            //     .catch((err) => {
            //         console.log(err)
            //     })
        },
        goNextMonth () {
            let self = this
            let month = self.month
            self.month = moment(month).add(1, 'months').format('YYYY-MM')
            self.refrash()
        },
        refrash () {
            let firstOfMonth = moment(this.month).format('YYYY-MM-01')
            let dayOfWeek = moment(firstOfMonth).isoWeekday()
            let beginOfCalendar = moment(firstOfMonth).subtract(dayOfWeek, 'd').format('YYYY-MM-DD')
            let endOfCalendar = moment(beginOfCalendar).add(41, 'd').format('YYYY-MM-DD')
            let tempDate = beginOfCalendar
            this.calendarData = []
            for (let row = 0; row < 6; row++) {
                let week = {
                    sun: { day: moment(tempDate).format('DD'), date: moment(tempDate).format('YYYY-MM-DD') },
                    mon: { day: moment(tempDate).add(1, 'days').format('DD'), date: moment(tempDate).add(1, 'days').format('YYYY-MM-DD') },
                    tue: { day: moment(tempDate).add(2, 'days').format('DD'), date: moment(tempDate).add(2, 'days').format('YYYY-MM-DD') },
                    wed: { day: moment(tempDate).add(3, 'days').format('DD'), date: moment(tempDate).add(3, 'days').format('YYYY-MM-DD') },
                    thu: { day: moment(tempDate).add(4, 'days').format('DD'), date: moment(tempDate).add(4, 'days').format('YYYY-MM-DD') },
                    fri: { day: moment(tempDate).add(5, 'days').format('DD'), date: moment(tempDate).add(5, 'days').format('YYYY-MM-DD') },
                    sat: { day: moment(tempDate).add(6, 'days').format('DD'), date: moment(tempDate).add(6, 'days').format('YYYY-MM-DD') }
                }
                this.calendarData.push(week)
                tempDate = moment(tempDate).add(7, 'd').format('YYYY-MM-DD')
            }
        },
        change () {
            this.refrash()
        }
    }
}
</script>

<style>
#calendar {
  width: 1052px;
}
#calendar .c-body {
  padding-top: 10px;
}
#calendar .el-table .header-cell {
  background: rgb(53, 235, 135);
}
#calendar .el-table .current-month-cell {
  background: #d5ebfd;
}
#calendar .el-table .el-table__row :hover {
  background: #d7f389;
}
</style>
