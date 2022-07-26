<template>    
      <!-- 主体 -->
      <el-main>
        未答卷
        <el-table
          :data="notAnswerList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
        >
          <el-table-column label="开始时间" prop="starttime"> </el-table-column>
          <el-table-column label="试卷名称" prop="title"> </el-table-column>
          <el-table-column label="发起人" prop="name"> </el-table-column>
          <el-table-column label="答题状态" prop="dstate"> </el-table-column>
          <el-table-column label="答卷时长"> 120分钟</el-table-column>
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
    data() {
      return {
        notAnswerList: [],
         search: '',
      }
    },
    methods: {
      handleDelete(index, row) {
        console.log(index, row)
      },
    },
    mounted(){
      let that = this;
        console.log(this);
        axios.post("http://localhost:8080/exam/no/findAll",{
          Headers:{
            'Context-Type':'application/x-www-form-urlencoded'
          }
        }).then(function(response) {
          let choice = response.data;
          console.log(choice);
          that.notAnswerList = JSON.parse(JSON.stringify(choice))
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
