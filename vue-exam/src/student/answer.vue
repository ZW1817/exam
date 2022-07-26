<template>    
      <!-- 主体 -->
      <el-main>
        已答卷
        <el-table
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
        >
          <el-table-column label="开始时间" prop="starttime"> </el-table-column>
          <el-table-column label="试卷名称" prop="title"> </el-table-column>
          <el-table-column label="发起人" prop="name"> </el-table-column>
          <el-table-column label="阅卷状态" prop="ystate"> </el-table-column>
          <el-table-column label="提交时间" prop="submittime"> </el-table-column>
          <el-table-column label="得分" prop="defen"> </el-table-column>
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
import axios from 'axios'
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
          
        ],
        search: '',
      }
    },
    mounted(){
      let that = this;
        axios.post("http://localhost:8080/exam/an/findAllAnswer",{
          Headers:{
            'Context-Type':'application/x-www-form-urlencoded'
          }
        }).then(function(response){
          let choice = response.data;
          that.tableData = JSON.parse(JSON.stringify(choice));
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
