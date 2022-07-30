<template>
<el-main>
  <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">
    <el-table-column label="教师编号" prop="tno" />
    <el-table-column label="姓名" prop="name" />
    <el-table-column label="性别" prop="sex" />
    <el-table-column label="主教学科" prop="major" />
    <el-table-column label="籍贯" prop="jiguan" />
    <el-table-column label="学历" prop="xueli" />
    <el-table-column label="职称" prop="zhicheng" />
    <el-table-column label="联系方式" prop="tell" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-row>
          <el-col :span="12">
            <el-button size="small" @click="updateTeacher(scope.row)">修改</el-button>
          </el-col>
          <el-col :span="12">
            <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
          </el-col>
        </el-row>
      </template>
    </el-table-column>
  </el-table>
 </el-main>
</template>

<script>
import axios from 'axios';
import qs from 'qs';
export default {
    name:"teacher",
      methods: {
        updateTeacher(row){
          let tno = row.tno;
        this.$router.push({path:"/admin/tedit",query:{tea:tno}});
        },
        handleDelete(index,row){
            let that = this;
            let tno = row.tno;
            axios({
              headers:{
                'deviceCode':'A95ZEF1-47B5-AC90BF3'
              },
              method:'post',
              url:'http://localhost:8080/exam/sysUser/deleteTeacher',
              data:qs.stringify({
                tno:tno
          }),
          }).then(function(response){
            if(response.data.code==1){
              window.alert(response.data.msg);
              that.$router.push("/admin/teachers");
            }
          })
          .catch(function(err){
          window.alert("删除异常");
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
      axios.post("http://localhost:8080/exam/sysUser/findTeacher",{
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