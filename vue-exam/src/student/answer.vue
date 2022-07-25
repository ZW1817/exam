<template>    
      <!-- 主体 -->
      <el-main>
        已答卷
        <el-table
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
        >
          <el-table-column label="开始时间" prop="date"> </el-table-column>
          <el-table-column label="试卷名称" prop="name"> </el-table-column>
          <el-table-column label="发起人" prop="date"> </el-table-column>
          <el-table-column label="阅卷状态" prop="name"> </el-table-column>
          <el-table-column label="提交时间" prop="date"> </el-table-column>
          <el-table-column label="得分" prop="date"> </el-table-column>
          <el-table-column align="right">
            <template #header>
              <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
            </template>
            <template #default="scope">
              <el-button
                size="mini"
                type="success"
                @click="handleDelete(scope.$index, scope.row)"
                >查看试卷</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-main>
</template>

<script>

export default {
    name:"notAnswer",
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath)
      },
      seeRow(index, rows) {
        rows.splice(index, 1)
      },
      handleDelete(index, row){
        console.log(index, row)
      }
    },
    data() {
      return {
        tableData: [
          {
            date: '2016-05-03',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
          {
            date: '2016-05-02',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
          {
            date: '2016-05-04',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
          {
            date: '2016-05-01',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
          {
            date: '2016-05-08',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
          {
            date: '2016-05-06',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
          {
            date: '2016-05-07',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333,
          },
        ]
      }
    }
}
</script>

<style scoped>
 .el-table{
    height: 600px;
}
.el-main{
    /* width: 1200px; */
    height:658px;
}

</style>
