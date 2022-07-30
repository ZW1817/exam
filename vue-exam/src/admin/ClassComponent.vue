<template>

<el-main>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="班级编号" prop="id" />
    <el-table-column label="班级名称" prop="name" />
    <el-table-column label="班主任" prop="tName" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-button
          size="small"
          type="primary"
          @click="dialog = true"
          >添加班级</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</el-main>
</template>

<script>
import axios from 'axios';
import qs from 'qs'
export default {
    name:"teacher",
      methods: {
        handleDelete(index,row){
          let that = this;
          let id = row.id;
          axios({
            headers:{
              'deviceCode':'A95ZEF1-47B5-AC90BF3'
            },
            method:'post',
            url:'http://localhost:8080/exam/sysUser/deleteClass',
            data:qs.stringify({
              id:id
            }),
        }).then(function(response){
          if(response.data.code==1){
            window.alert(response.data.msg);
            that.$router.push("/admin/classes");
          }
        })
        }
      },
    data() {
      return {
        tableData: [],
         search: '',
      }
    },
    mounted(){
      let that = this;
      console.log(this);
      axios.post("http://localhost:8080/exam/sysUser/findBanji",{
        Headers:{
          'Context-Type':'application/x-www-form-urlencoded'
        }
      }).then(function(response) {
        let choice = response.data;
        that.tableData = JSON.parse(JSON.stringify(choice))
      })
    }
    }

</script>
<style scoped>
.el-table{
    height: 620px;
}

.el-main{
    width: 1200px;
}
</style>