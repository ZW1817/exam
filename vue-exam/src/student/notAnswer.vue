<template>    
      <!-- 主体 -->
      <el-main>
        未答卷
        <el-table
          :data="notAnswerList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
        >
          <el-table-column label="开始时间" prop="starttime" format="YYYY-MM-DD"> </el-table-column>
          <el-table-column label="试卷名称" prop="title"> </el-table-column>
          <el-table-column label="发起人" prop="name"> </el-table-column>
          <el-table-column label="答卷时长"> 120分钟</el-table-column>
          <el-table-column align="right">
            <template #header>
              <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
            </template>
            <template #default="scope">
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >开始答题</el-button
              >
            </template>
          </el-table-column>
        </el-table>
      </el-main>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
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
        let _this = this;
        let s = {
          shijuanid:row.shijuanid
        }

        axios.post("http://localhost:8080/exam/student/findAllTi",
          qs.stringify(s),
          {
          Headers:{
            'Context-Type':'application/x-www-form-urlencoded'
          }
        }).then(function(response){
          // console.log(response.data);
          _this.$store.commit('insert',response.data);
          // console.log(_this.$store.state.shijuanList);
          _this.$router.push("/student/doTi");
        })
      },
    },
    mounted(){
      let that = this;
      let stno = {
        stno :that.$store.state.user.stno
        };
        console.log(this);
        axios.post("http://localhost:8080/exam/no/findAll",
        qs.stringify(stno),
        {
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
