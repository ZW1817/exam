<template>    
      <!-- 主体 -->
      <el-main>
        未答卷
        <el-table
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
        >
          <el-table-column label="开始时间" prop="date"> </el-table-column>
          <el-table-column label="试卷名称" prop="name"> </el-table-column>
          <el-table-column label="发起人" prop="date"> </el-table-column>
          <el-table-column label="答题状态" prop="name"> </el-table-column>
          <el-table-column label="答卷时长" prop="date"> </el-table-column>
          <el-table-column align="right">
            <template #header>
              <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
            </template>
            <template #default="scope">
              <router-link to="/student/doTi"><el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >开始答题</el-button
              ></router-link>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
</template>

<script>
import axios from 'axios'
export default {
    name:"notAnswer",
      methods: {
        handleDelete(index, row) {
          console.log(index, row)
        },
    },
    data() {
      return {
        tableData: [
          {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄',
          },
          {
            date: '2016-05-04',
            name: '刘小虎',
            address: '上海市普陀区金沙江路 1517 弄',
          },
          {
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄',
          },
          {
            date: '2016-05-03',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1516 弄',
          },
        ],
         search: '',
      }
    },
    mounted(){
      let that = this;
        console.log(this);
        axios.post("http://localhost:8080/exam/findAll",{
          Headers:{
            'Context-Type':'application/x-www-form-urlencoded'
          }
        }).then(function(response) {
          let choice = response.data;
          this.tableData = JSON.parse(choice)

        })
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
